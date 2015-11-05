/* 
 * This file is part of the Kompics component model runtime.
 *
 * Copyright (C) 2009 Swedish Institute of Computer Science (SICS) 
 * Copyright (C) 2009 Royal Institute of Technology (KTH)
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package se.sics.kola;

import com.google.common.io.Files;
import com.sun.codemodel.writer.SingleStreamCodeWriter;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import se.sics.kola.lexer.Lexer;
import se.sics.kola.lexer.LexerException;
import se.sics.kola.node.Start;
import se.sics.kola.parser.Parser;
import se.sics.kola.parser.ParserException;
import se.sics.kola.sourcegen.JavaSourceGenerator;
import se.sics.kola.sourcegen.ResolutionContext;

/**
 *
 * @author lkroll
 */
public class Main {

    private final static AtomicBoolean parsingError = new AtomicBoolean(false);

    public static void main(String[] args) {

        Options opts = prepareOptions();
        HelpFormatter formatter = new HelpFormatter();
        try {
            CommandLineParser cliparser = new DefaultParser();
            CommandLine cmd = cliparser.parse(opts, args);
            String[] files = cmd.getArgs();
            long start_time, stop_time; // times compilation

            if (files.length < 1) {
                formatter.printHelp("Usage: kolac <options> <source files>", opts);
                System.exit(0);
            }
            SourceWriter sw;
            if (cmd.hasOption("s")) {
                String outPath = cmd.getOptionValue("s");
                sw = new SourceWriter(outPath);
            } else {
                sw = new SourceWriter();
            }
            List<File> sourceFiles = findSources(files);
            ExecutorService execs = Executors.newCachedThreadPool();
            start_time = System.currentTimeMillis();
            Map<File, Future<Start>> futures = new HashMap<>();
            for (final File f : sourceFiles) {
                Future<Start> fres = execs.submit(new Callable<Start>() {

                    @Override
                    public Start call() throws Exception {
                        return parse(f);
                    }
                });
                futures.put(f, fres);
            }
            Map<File, Start> starts = new HashMap<>();
            for (Entry<File, Future<Start>> e : futures.entrySet()) {
                Start s = e.getValue().get();
                starts.put(e.getKey(), s);
            }
            stop_time = System.currentTimeMillis();
            System.out.println("Parsed all files in " + (stop_time - start_time) + "ms.");

            if (parsingError.get()) {
                System.err.println("Errors occurred during parsing stage. Exiting...");
                System.exit(1);
            }

            ResolutionContext context = new ResolutionContext();
            for (Entry<File, Start> e : starts.entrySet()) {
                System.out.println("Analysing AST for " + e.getKey());
                Start ast = e.getValue();
                context.setFile(e.getKey().getName());
                // print
//                PrintAdapter printer = new PrintAdapter();
//                ast.apply(printer);
//                printer.print();
                // check program semantics
                //ast.apply(new SemanticAnalyser());
                // generate class file
                JavaSourceGenerator jsg = new JavaSourceGenerator(context);
                ast.apply(jsg);
                context.setFile(null);
            }
//            if (!context.checkAllProxiesDeclared()) {
//                Logger.error("There are unresolved types remaining. No code will be generated.");
//                System.exit(1);
//            }
            context.printDeclaredTypes();
            if (cmd.hasOption("debugPrint")) {
                System.out.println("DONE with compilation unit. Generated Code: ");
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                context.unit.build(new SingleStreamCodeWriter(out));
                out.writeTo(System.out);
            }
            sw.writeOut(context.unit);
        } catch (ParseException ex) {
            System.err.println("Invalid commandline options: " + ex.getMessage());
            formatter.printHelp("Usage: kolac <options> <source files>", opts);
            System.exit(1);
        } catch (InterruptedException | ExecutionException ex) {
            System.err.println("Parser error: " + ex.getMessage());
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("File writer error: " + ex.getMessage());
            System.exit(1);
        }
    }

    private static Start parse(File f) {
        try (FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                PushbackReader pbr = new PushbackReader(br, 1024);) {

            // create lexer
            Lexer lexer = new Lexer(pbr);

            // parser program
            Parser parser = new Parser(lexer);

            Start ast = parser.parse();
            return ast;
        } catch (ParserException ex) {
            StringBuilder sb = new StringBuilder();
            sb.append("There was an error parsing ");
            sb.append(f.getName());
            sb.append(".\n  Found: \'");
            sb.append(ex.getToken().getText());
            sb.append("\'\n");
            sb.append(ex.getMessage());
            Logger.error(f.getName(), ex.getToken(), sb.toString());
            parsingError.set(true);
            return null;
        } catch (LexerException ex) {
            StringBuilder sb = new StringBuilder();
            sb.append("There was an error tokenizing ");
            sb.append(f.getName());
            sb.append(".\n  Found: \'");
            sb.append(ex.getToken().getText());
            sb.append("\'\n");
            sb.append(ex.getMessage());
            Logger.error(f.getName(), ex.getToken(), sb.toString());
            parsingError.set(true);
            return null;
        } catch (IOException ex) {
            //System.err.println(e.getMessage());
            parsingError.set(true);
            ex.printStackTrace(System.err);
            return null;
        }
    }

    private static Options prepareOptions() {
        Options opts = new Options();

        opts.addOption("s", true, "Specify where to place generated source files");
        
        opts.addOption("p", "debugPrint", false, "Print generated code to Console as well.");

        return opts;
    }

    private static List<File> findSources(String[] files) {
        List<File> sfiles = new LinkedList<>();
        Queue<File> todo = new LinkedList<>();
        for (String path : files) {
            todo.offer(new File(path));
        }
        while (!todo.isEmpty()) {
            File f = todo.poll();
            if (f.isDirectory()) {
                File[] children = f.listFiles();
                for (File child : children) {
                    todo.offer(child);
                }
            } else {
                String ext = Files.getFileExtension(f.getAbsolutePath());
                if (ext.equalsIgnoreCase("java") || ext.equalsIgnoreCase("kola")) {
                    sfiles.add(f);
                }
            }
        }
        return sfiles;
    }

}
