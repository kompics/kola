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
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import se.sics.kompics.Kompics;

/**
 *
 * @author lkroll
 */
@RunWith(JUnit4.class)
public class GenerationTest {

    public static final String targetPath = "target/generated-sources/";

    @Before
    public void setUp() {
        try {
            clean(targetPath);
        } catch (IOException ex) {
            System.err.println("Couldn't clean target path: " + ex.getMessage());
        }
    }

    @Test
    public void pureJavaTest() {
        try {
            //System.out.println(new java.io.File( "." ).getCanonicalPath());

            Main.main(new String[]{"-s", targetPath, "src/test/resources/se/sics/kola/BasicTests.kola"});
            compile(targetPath);
            ClassLoader cl = new URLClassLoader(new URL[]{(new File(targetPath)).toURI().toURL()});
            Class testClass = cl.loadClass("se.sics.kola.BasicTests");
            Object o = testClass.newInstance();
            Method m = testClass.getMethod("test");
            Object ret = m.invoke(o);
            boolean res = ((Boolean) ret);
            Assert.assertTrue(res);
        } catch (IOException |
                InterruptedException |
                ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                NoSuchMethodException |
                SecurityException |
                IllegalArgumentException ex) {
            ex.printStackTrace(System.err);
            Assert.fail(ex.getMessage());
        } catch (InvocationTargetException ex) {
            Throwable cause = ex.getCause();
            if (cause instanceof AssertionFailedError) {
                throw (AssertionFailedError) cause;
            } else {
                cause.printStackTrace(System.err);
                Assert.fail(cause.getMessage());
            }
        }
    }
    
    @Test
    public void kolaTest() {
        try {
            //System.out.println(new java.io.File( "." ).getCanonicalPath());
            TestUtil.reset("Kola Test");
            Main.main(new String[]{"-s", targetPath, "src/test/resources/se/sics/kola/KolaTests.kola"});
            compile(targetPath);
            ClassLoader cl = new URLClassLoader(new URL[]{(new File(targetPath)).toURI().toURL()});
            Class testClass = cl.loadClass("se.sics.kola.KolaTestC");
            Kompics.createAndStart(testClass, 1);
            TestUtil.waitFor("STARTED");
            TestUtil.waitFor("RECEIVED");
            TestUtil.waitFor("REPLIED");
            Kompics.shutdown();
            
            
//            Object o = testClass.newInstance();
//            Method m = testClass.getMethod("test");
//            Object ret = m.invoke(o);
//            boolean res = ((Boolean) ret);
//            Assert.assertTrue(res);
        } catch (IOException |
                InterruptedException |
                ClassNotFoundException |
                SecurityException |
                IllegalArgumentException ex) {
            ex.printStackTrace(System.err);
            Assert.fail(ex.getMessage());
        }
    }

    private void compile(String path) throws IOException, InterruptedException {
        List<File> sourceFiles = findSources(path);
        String[] args = new String[sourceFiles.size() + 3];
        args[0] = "javac";
        args[1] = "-cp";
        args[2] = System.getProperty("java.class.path");
        for (int i = 0; i < sourceFiles.size(); i++) {
            args[i + 3] = sourceFiles.get(i).getAbsolutePath();
        }
        Process p = Runtime.getRuntime().exec(args);
        String s = null;
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

        System.out.println("****** BEGIN javac output ********");

        while (!p.waitFor(100, TimeUnit.MILLISECONDS)) {
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // read any errors from the attempted command
            while ((s = stdError.readLine()) != null) {
                System.err.println(s);
            }
        }
        System.out.println("****** END javac output ********");
    }

    private void clean(String path) throws IOException {
        final Path start = Paths.get(path);
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e)
                    throws IOException {
                if (dir.equals(start)) {
                    return FileVisitResult.CONTINUE;
                }
                if (e == null) {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                } else {
                    // directory iteration failed
                    throw e;
                }
            }
        });
    }

    private List<File> findSources(String path) {
        List<File> sfiles = new ArrayList<>();
        Queue<File> todo = new LinkedList<>();
        todo.offer(new File(path));

        while (!todo.isEmpty()) {
            File f = todo.poll();
            if (f.isDirectory()) {
                File[] children = f.listFiles();
                for (File child : children) {
                    todo.offer(child);
                }
            } else {
                String ext = com.google.common.io.Files.getFileExtension(f.getAbsolutePath());
                if (ext.equalsIgnoreCase("java")) {
                    sfiles.add(f);
                }
            }
        }
        return sfiles;
    }

}
