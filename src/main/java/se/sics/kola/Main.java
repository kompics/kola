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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import se.sics.kola.lexer.Lexer;
import se.sics.kola.lexer.LexerException;
import se.sics.kola.node.Start;
import se.sics.kola.parser.Parser;
import se.sics.kola.parser.ParserException;

/**
 *
 * @author lkroll
 */
public class Main {

    public static void main(String[] args) {
        long start_time, stop_time; // times compilation

        if (args.length < 1) {
            System.out.println("Usage:");
            System.out.println("java -jar kolac.jar <filename>");
        }

        try (FileReader fr = new FileReader(args[0]);
                BufferedReader br = new BufferedReader(fr);
                PushbackReader pbr = new PushbackReader(br, 1024);) {
            start_time = System.currentTimeMillis();

            // create lexer
            Lexer lexer = new Lexer(pbr);

            // parser program
            Parser parser = new Parser(lexer);

            Start ast = parser.parse();

            // check program semantics
            //ast.apply(new SemanticAnalyser());
            // generate class file
            //ast.apply(new ClassGenerator());
        } catch (ParserException | LexerException | IOException e) {
            System.out.println(e);
        }
    }
}
