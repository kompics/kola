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

import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JEnumConstant;
import com.sun.codemodel.JExpression;
import se.sics.kola.Logger;
import se.sics.kola.node.AEnumConstant;
import se.sics.kola.node.PArgument;
import se.sics.kola.sourcegen.ArgumentAdapter.Argumentable;

/**
 *
 * @author lkroll
 */
class EnumBodyAdapter extends ClassBodyAdapter {

    EnumBodyAdapter(ResolutionContext context, JDefinedClass clazz) {
        super(context, clazz);
    }

    @Override
    public void caseAEnumConstant(AEnumConstant node) {
//        TypeModifierAdapter modap = new TypeModifierAdapter();
//        for (PModifier m : node.getModifier()) {
//            m.apply(modap);
//        }
//        int mods = modap.getMods();
        if (!node.getModifier().isEmpty()) {
            Logger.error(context.getFile(), node.getIdentifier(), "CodeModel does not support modifiers for enum constants, yet...");
        }
        JEnumConstant ec = clazz.enumConstant(node.getIdentifier().getText());
        EnumArgumentable ea = new EnumArgumentable(ec);
        for (PArgument arg : node.getArgument()) {
            ArgumentAdapter aa = new ArgumentAdapter(ea, context);
            arg.apply(aa);
        }
        if (node.getClassBody() != null) {
            Logger.error(context.getFile(), node.getIdentifier(), "CodeModel does not support class bodies for enum constants, yet...");
        }
    }

    static class EnumArgumentable implements Argumentable {

        private final JEnumConstant ec;

        EnumArgumentable(JEnumConstant ec) {
            this.ec = ec;
        }

        @Override
        public Argumentable arg(JExpression expr) {
            ec.arg(expr);
            return this;
        }
    }

}
