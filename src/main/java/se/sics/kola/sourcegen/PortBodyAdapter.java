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
package se.sics.kola.sourcegen;

import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JInvocation;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AClassType;
import se.sics.kola.node.AIndicationsDeclaration;
import se.sics.kola.node.ARequestsDeclaration;

/**
 *
 * @author lkroll
 */
class PortBodyAdapter extends DepthFirstAdapter {
    
    public static enum Direction {
        INDICATION("indication"),
        REQUEST("request"); 
        
        public final String method;
        
        private Direction(String method) {
            this.method = method;
        }
    }

    private final JBlock initBlock;
    private final ResolutionContext context;
    private Direction dir = null;

    PortBodyAdapter(JBlock initBlock, ResolutionContext context) {
        this.initBlock = initBlock;
        this.context = context;
    }
    
    @Override
    public void inAIndicationsDeclaration(AIndicationsDeclaration node) {
        dir = Direction.INDICATION;
    }
    @Override
    public void outAIndicationsDeclaration(AIndicationsDeclaration node) {
        dir = null;
    }
    
    @Override
    public void inARequestsDeclaration(ARequestsDeclaration node) {
        dir = Direction.REQUEST;
    }
    @Override
    public void outARequestsDeclaration(ARequestsDeclaration node) {
        dir = null;
    }
    
    @Override
    public void caseAClassType(AClassType type) {
        TypeAdapter ta = new TypeAdapter(context);
        ta.caseAClassType(type);
        JClass clazz = (JClass) ta.type;
        JInvocation inv = initBlock.invoke(dir.method);
        inv.arg(clazz.dotclass());
    }
}
