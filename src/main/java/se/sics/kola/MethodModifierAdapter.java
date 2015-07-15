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

import com.sun.codemodel.JMod;
import se.sics.kola.analysis.DepthFirstAdapter;
import se.sics.kola.node.AAbstractModifier;
import se.sics.kola.node.AAnnotationModifier;
import se.sics.kola.node.AFinalModifier;
import se.sics.kola.node.ANativeModifier;
import se.sics.kola.node.APrivateModifier;
import se.sics.kola.node.AProtectedModifier;
import se.sics.kola.node.APublicModifier;
import se.sics.kola.node.AStaticModifier;
import se.sics.kola.node.AStrictfpModifier;
import se.sics.kola.node.ASynchronizedModifier;
import se.sics.kola.node.ATransientModifier;
import se.sics.kola.node.AVolatileModifier;

/**
 *
 * @author lkroll
 */
class MethodModifierAdapter extends DepthFirstAdapter {

    private int mods = 0;

    MethodModifierAdapter() {
    }

    public int getMods() {
        return this.mods;
    }

    @Override
    public void inAPublicModifier(APublicModifier node) {
        mods = mods | JMod.PUBLIC;
    }

    @Override
    public void inAProtectedModifier(AProtectedModifier node) {
        mods = mods | JMod.PROTECTED;
    }

    @Override
    public void inAPrivateModifier(APrivateModifier node) {
        mods = mods | JMod.PRIVATE;
    }

    @Override
    public void inAAbstractModifier(AAbstractModifier node) {
        mods = mods | JMod.ABSTRACT;
    }

    @Override
    public void inAStaticModifier(AStaticModifier node) {
        mods = mods | JMod.STATIC;
    }

    @Override
    public void inAFinalModifier(AFinalModifier node) {
        mods = mods | JMod.FINAL;
    }

    @Override
    public void inAStrictfpModifier(AStrictfpModifier node) {
        Logger.error(node.getStrictfpKeyword(), "CodeModel does not support strictfp modifier. Ignoring...");
    }

    @Override
    public void inATransientModifier(ATransientModifier node) {
        Logger.error(node.getTransientKeyword(), "Modifier not supported here. Ignoring...");
    }

    @Override
    public void inAVolatileModifier(AVolatileModifier node) {
        Logger.error(node.getVolatileKeyword(), "Modifier not supported here. Ignoring...");
    }

    @Override
    public void inASynchronizedModifier(ASynchronizedModifier node) {
        mods = mods | JMod.SYNCHRONIZED;
    }

    @Override
    public void inANativeModifier(ANativeModifier node) {
        mods = mods | JMod.NATIVE;
    }
    
    @Override
    public void caseAAnnotationModifier(AAnnotationModifier node) {
        // stop recursing
    }
}
