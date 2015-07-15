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

import java.util.Iterator;
import java.util.LinkedList;
import se.sics.kola.node.AArgsWithName;
import se.sics.kola.node.AName;
import se.sics.kola.node.ATypeDeclSpecifier;
import se.sics.kola.node.PArgsWithName;
import se.sics.kola.node.PName;
import se.sics.kola.node.PTypeArguments;
import se.sics.kola.node.TIdentifier;

/**
 *
 * @author lkroll
 */
class Util {

    static String nameToString(PName pname) {
        AName name = (AName) pname;
        StringBuilder sb = new StringBuilder();

        for (Iterator<TIdentifier> it = name.getIdentifier().iterator(); it.hasNext();) {
            TIdentifier id = it.next();
            sb.append(id.getText());
            if (it.hasNext()) {
                sb.append('.');
            }
        }
        return sb.toString();
    }

    static LinkedList<IdWithOptArgs> shiftTDS(ATypeDeclSpecifier spec, ResolutionContext context) {
        AName firstName = (AName) spec.getName();
        
        LinkedList<IdWithOptArgs> list = new LinkedList<>();
        for (TIdentifier id : firstName.getIdentifier()) {
            IdWithOptArgs iwoa = new IdWithOptArgs();
            iwoa.id = id;
            list.add(iwoa);
        }
        IdWithOptArgs lastIwoa = list.getLast();
        for (PArgsWithName pawn : spec.getArgsWithName()) {
            AArgsWithName aawn = (AArgsWithName) pawn;
            if (lastIwoa != null) {
                lastIwoa.args = aawn.getTypeArguments();
            }
            for (TIdentifier id : ((AName) aawn.getName()).getIdentifier()) {
                IdWithOptArgs iwoa = new IdWithOptArgs();
                iwoa.id = id;
                list.add(iwoa);
            }
            lastIwoa = list.getLast();
        }
        return list;
    }

    static class IdWithOptArgs {

        TIdentifier id;
        PTypeArguments args;
    }
}
