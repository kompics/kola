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

import se.sics.kola.node.AName;
import se.sics.kola.node.PName;
import se.sics.kola.node.Token;

/**
 *
 * @author lkroll
 */
public class Logger {

    public static void error(String file, PName name, String msg) {
        AName aname = (AName) name;
        if (aname.getIdentifier().isEmpty()) {
            error(file, (Token) null, msg);
        } else {
            error(file, aname.getIdentifier().peekFirst(), msg);
        }

    }

    public static void error(String file, Token t, String msg) {
        if (t != null) {
            System.err.println("ERROR at (" + file + ", l: " + t.getLine() + ", p: " + t.getPos() + "): " + msg);
        } else {
            System.err.println("ERROR: " + msg);
        }
    }

    public static void error(String msg) {
        error(null, (Token) null, msg);
    }

    public static void warn(String file, PName name, String msg) {
        AName aname = (AName) name;
        if (aname.getIdentifier().isEmpty()) {
            warn(file, (Token) null, msg);
        } else {
            warn(file, aname.getIdentifier().peekFirst(), msg);
        }

    }

    public static void warn(String file, Token t, String msg) {
        if (t != null) {
            System.err.println("WARN at (" + file + ", l: " + t.getLine() + ", p: " + t.getPos() + "): " + msg);
        } else {
            System.err.println("WARN: " + msg);
        }
    }

    public static void warn(String msg) {
        error(null, (Token) null, msg);
    }
}
