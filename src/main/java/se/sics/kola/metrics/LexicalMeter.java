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
package se.sics.kola.metrics;

import java.io.IOException;
import se.sics.kola.lexer.Lexer;
import se.sics.kola.lexer.LexerException;
import se.sics.kola.node.Token;

/**
 *
 * @author lkroll
 */
public class LexicalMeter {

    private final Lexer lexer;
    private Metrics metrics = null;

    public LexicalMeter(Lexer lexer) {
        this.lexer = lexer;
    }

    public Metrics metrics() {
        if (metrics != null) {
            return metrics;
        } else {
            throw new RuntimeException("Run measure() before requesting metrics!");
        }
    }

    public void measure() throws LexerException, IOException {
        MetricsAdapter ma = new MetricsAdapter();
        while (!ma.done) {
            Token t = lexer.next();
            t.apply(ma);
        }
//        System.out.println("n1: " + ma.distinctOperators.size());
//        System.out.println("n2: " + ma.distinctOperands.size());
//        System.out.println("N1: " + ma.operators);
//        System.out.println("N2: " + ma.operands);
//        System.out.println("LOC: " + ma.loc);
        metrics = new Metrics(
                ma.distinctOperators,
                ma.distinctOperands,
                ma.operators,
                ma.operands,
                ma.loc,
                1);
    }

}
