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

import com.google.common.base.Optional;
import com.larskroll.common.Either;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldRef;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JLabel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import se.sics.kola.Logger;
import se.sics.kola.node.AName;
import se.sics.kola.node.TIdentifier;
import se.sics.kola.sourcegen.ExpressionAdapter.ExpressionParent;
import static se.sics.kola.sourcegen.Util.nameToString;

/**
 *
 * @author lkroll
 */
class ResolutionContext {

    JCodeModel unit;
    Map<String, JClass> imports = new HashMap<>();
    Map<String, JDefinedClass> declaredClasses = new HashMap<>();
    private final LinkedList<Set<String>> generics = new LinkedList<>();
    private final LinkedList<Map<String, JLabel>> labels = new LinkedList<>();

    void pushLevel() {
        generics.push(new HashSet<String>());
        labels.push(new HashMap<String, JLabel>());
    }

    void popLevel() {
        generics.pop();
        labels.pop();
    }

    void addGeneric(String g) {
        Set<String> s = generics.peek();
        s.add(g);
    }

    void addLabel(String name, JLabel label) {
        Map<String, JLabel> s = labels.peek();
        s.put(name, label);
    }
    
    Optional<JLabel> findLabel(String name) {
        for (Map<String, JLabel> labelMap : labels) {
            JLabel label = labelMap.get(name);
            if (label != null) {
                return Optional.of(label);
            }
        }
        return Optional.absent();
    }

    JClass resolveType(String name) throws ClassNotFoundException {
        for (Set<String> genericSet : generics) {
            if (genericSet.contains(name)) {
                return unit.directClass(name);
            }
        }
        JDefinedClass jcd = declaredClasses.get(name);
        if (jcd != null) {
            return jcd;
        }
        JClass jc = imports.get(name);
        if (jc == null) {
            // empty package
            try {
                Class c = ClassLoader.getSystemClassLoader().loadClass(name);
                return unit.ref(c);
            } catch (ClassNotFoundException ex) {
                // ignore
            }
            // lang
            String langName = "java.lang." + name;
            try {
                Class c = ClassLoader.getSystemClassLoader().loadClass(langName);
                return unit.ref(c);
            } catch (ClassNotFoundException ex) {
                // ignore
            }
            if (name.contains(".")) { // needs to be fully qualified
                jc = unit.ref(name);
            } else {
                throw new ClassNotFoundException("Could not find class of type: " + name);
            }
        }
        return jc;
    }

    JInvocation resolveInvocation(AName name, ExpressionParent parent) {
        if (name.getIdentifier().size() == 1) {
            return parent.invoke(nameToString(name));
        } else {
            LinkedList<TIdentifier> ids = name.getIdentifier();
            TIdentifier methodId = ids.pollLast();
            Either<JClass, JFieldRef> e = resolve(ids);
            if (e.isLeft()) {
                JInvocation ji = e.getLeft().staticInvoke(methodId.getText());
                parent.addInvocation(ji);
                return ji;
            } else {
                JInvocation ji = e.getRight().invoke(methodId.getText());
                parent.addInvocation(ji);
                return ji;
            }
        }
    }

    JFieldRef resolveField(AName aName) {
        LinkedList<TIdentifier> ids = aName.getIdentifier();
        Either<JClass, JFieldRef> e = resolve(ids);
        if (e.isRight()) {
            return e.getRight();
        } else {
            Logger.error(ids.peekFirst(), "Expected a field reference here, not a class: " + e.getLeft().fullName());
            return null;
        }
    }

    Either<JClass, JFieldRef> resolve(LinkedList<TIdentifier> ids) {
        LinkedList<TIdentifier> prefix = new LinkedList<>();
        JClass jc = null;
        while (!ids.isEmpty()) {
            prefix.offer(ids.pollFirst());
            try {
                jc = resolveType(nameToString(prefix));
                break;
            } catch (ClassNotFoundException ex) {
                // ignore
            }
        }

        if (jc == null) {
            // restore ids
            while (!prefix.isEmpty()) {
                ids.addFirst(prefix.pollLast());
            }
            TIdentifier firstId = ids.pollFirst();
            JFieldRef field = JExpr.ref(firstId.getText());
            Either<JClass, JFieldRef> ret = resolve(ids, field);
            ids.addFirst(firstId);
            return ret;
        } else {
            Either<JClass, JFieldRef> ret = resolve(ids, jc);
            // restore ids
            while (!prefix.isEmpty()) {
                ids.addFirst(prefix.pollLast());
            }
            return ret;
        }
    }

    private Either<JClass, JFieldRef> resolve(LinkedList<TIdentifier> ids, JFieldRef infield) {
        if (ids.isEmpty()) {
            return Either.right(infield);
        }
        TIdentifier firstId = ids.pollFirst();
        // Note this could also be instance class reference, but there's no way to reflect that here...at least not without resolving the JVar I guess
        JFieldRef field = infield.ref(firstId.getText());
        Either<JClass, JFieldRef> ret = resolve(ids, field);
        ids.addFirst(firstId);
        return ret;
    }

    private Either<JClass, JFieldRef> resolve(LinkedList<TIdentifier> ids, JClass inClass) {
        if (ids.isEmpty()) {
            return Either.left(inClass);
        }
        TIdentifier firstId = ids.pollFirst();
        String cName = inClass.fullName() + "." + firstId.getText();
//        try {
//            JClass jc = resolveType(cName);
//            Either<JClass, JFieldRef> ret = resolve(ids, jc);
//            ids.addFirst(firstId);
//            return ret;
//        } catch (ClassNotFoundException ex) {
        JFieldRef field = inClass.staticRef(firstId.getText());
        Either<JClass, JFieldRef> ret = resolve(ids, field);
        ids.addFirst(firstId);
        return ret;
//        }
    }
}
