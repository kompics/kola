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
import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JClassProxy;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExprProxy;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JField;
import com.sun.codemodel.JFieldProxy;
import com.sun.codemodel.JFieldRef;
import com.sun.codemodel.JGenProxy;
import com.sun.codemodel.JGenerable;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JLabel;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JType;
import com.sun.codemodel.JTypeVar;
import com.sun.codemodel.JVar;
import java.util.LinkedList;
import se.sics.kola.Logger;
import se.sics.kola.node.AName;
import se.sics.kola.node.PName;
import se.sics.kola.node.TIdentifier;
import static se.sics.kola.sourcegen.Util.nameToString;

/**
 *
 * @author lkroll
 */
public class ResolutionContext {

    public final JCodeModel unit = new JCodeModel();
    private final GlobalScope global = new GlobalScope(unit);
    private Scope current = global;
    private final LinkedList<Scope> scopeStack = new LinkedList<>();

    {
        scopeStack.push(global);
    }
    private String fileName = null;

    public void setFile(String name) {
        this.fileName = name;
    }

    String getFile() {
        if (fileName == null) {
            return "{FileUnknown}";
        } else {
            return fileName;
        }
    }

    void pushPackage(String name) {
        PackageScope ps = global.getPackage(name);
        if (ps == null) {
            ps = global.addPackage(unit._package(name));
        }
        current = ps;
        scopeStack.push(current);
        //System.out.println("Pushing scope " + current);
        if (fileName != null) {
            current = new FileScope(fileName, ps);
            scopeStack.push(current);
            //System.out.println("Pushing scope " + current);
        }
    }

    void popPackage() {
        current = scopeStack.pop();
        if (current instanceof FileScope) {
            current = scopeStack.pop();
        }
    }

    void pushStatementScope() {
        current = new StatementScope(current);
        scopeStack.push(current);
        //System.out.println("Pushing scope " + current);
    }

    void popScope() {
        Scope old = scopeStack.pop();
        //System.out.println("Popping Scope " + old);
        current = scopeStack.peek();
    }

    void addGeneric(String g, JTypeVar var) {
        if (current instanceof Scope.Generic) {
            Scope.Generic genericScope = (Scope.Generic) current;
            genericScope.addGeneric(g, var);
        } else {
            Logger.error("Cannot add generic (" + g + ") to a Scope (" + current.getClass().getName() + ") that doesn't allow generics!");
            throw new RuntimeException("Invalid Scope for operation!");
        }
    }

    void addLabel(String name, JLabel label) {
        if (current instanceof Scope.Labelled) {
            Scope.Labelled labelledScope = (Scope.Labelled) current;
            labelledScope.addLabel(name, label);
        } else {
            Logger.error("Cannot add label (" + name + ") to a Scope (" + current.getClass().getName() + ") that doesn't allow labels!");
            throw new RuntimeException("Invalid Scope for operation!");
        }
    }

    void addField(String name, JVar var, Field.Type type) {
        Field f = new Field(type, var, current);
        if (current instanceof Scope.Fieldy) {
            Scope.Fieldy fieldyScope = (Scope.Fieldy) current;
            fieldyScope.addField(name, f);
        } else {
            Logger.error("Cannot add a field/variable (" + name + ") to a Scope (" + current.getClass().getName() + ") that doesn't allow fields/variables!");
            throw new RuntimeException("Invalid Scope for operation!");
        }
    }

    void importType(String name) {
        if (current instanceof FileScope) {
            FileScope fScope = (FileScope) current;
            fScope.importType(name);
        } else {
            Logger.error("Cannot add an import (" + name + ") to a Scope (" + current.getClass().getName() + ") that doesn't allow imports!");
            throw new RuntimeException("Invalid Scope for operation!");
        }
    }

    void importOnDemand(String name) {
        if (current instanceof FileScope) {
            FileScope fScope = (FileScope) current;
            fScope.importTypeOnDemand(name);
        } else {
            Logger.error("Cannot add an import (" + name + ") to a Scope (" + current.getClass().getName() + ") that doesn't allow imports!");
            throw new RuntimeException("Invalid Scope for operation!");
        }
    }

    void importStatic(String name) {
        if (current instanceof FileScope) {
            FileScope fScope = (FileScope) current;
            fScope.importStatic(name);
        } else {
            Logger.error("Cannot add an import (" + name + ") to a Scope (" + current.getClass().getName() + ") that doesn't allow imports!");
            throw new RuntimeException("Invalid Scope for operation!");
        }
    }

    void importStaticOnDemand(String name) {
        if (current instanceof FileScope) {
            FileScope fScope = (FileScope) current;
            fScope.importStaticOnDemand(name);
        } else {
            Logger.error("Cannot add an import (" + name + ") to a Scope (" + current.getClass().getName() + ") that doesn't allow imports!");
            throw new RuntimeException("Invalid Scope for operation!");
        }
    }

    JClass resolveType(PName name) {
        AName aname = (AName) name;
        return resolveType(aname.getIdentifier());
    }

    JClass resolveType(LinkedList<TIdentifier> ids) {
        if (ids.isEmpty()) {
            throw new RuntimeException("Fuck you!");
        }
        if (ids.size() == 1) {
            return resolveType(ids.peek());
        }
        return new JClassProxy(unit, ids.peekLast().getText(), new QualifiedClassResolver(ids, current));
    }

    JClass resolveType(TIdentifier id) {
        return new JClassProxy(unit, id.getText(), new ShortClassResolver(id, current));
    }

    Field resolveField(PName name) {
        AName aname = (AName) name;
        return resolveField(aname.getIdentifier());
    }

    Field resolveField(LinkedList<TIdentifier> ids) {
        if (ids.isEmpty()) {
            throw new RuntimeException("Fuck you!");
        }
        if (ids.size() == 1) {
            return resolveField(ids.peek());
        }
        LinkedList<TIdentifier> prefix = new LinkedList<>(ids);
        String name = prefix.pollLast().getText();
        JFieldProxy jfp = new JFieldProxy(name, new QualifiedFieldResolver(prefix, name, current));
        return new Field(Field.Type.UNKOWN, jfp, null);
    }

    Field resolveField(TIdentifier id) {
        Field f = current.resolveField(id.getText());
        if (f == null) {
            JFieldProxy jfp = new JFieldProxy(id.getText(), new ShortFieldResolver(id, current));
            return new Field(Field.Type.UNKOWN, jfp, null);
        } else {
            return f;
        }
    }

    Optional<JLabel> resolveLabel(String id) {
        JLabel l = current.resolveLabel(id);
        if (l == null) {
            return Optional.absent();
        } else {
            return Optional.of(l);
        }
    }

    JDefinedClass declare(int mods, TIdentifier identifier, ClassType ctype) {
        Optional<String> oa = Optional.absent();
        return declare(mods, identifier, ctype, oa);
    }

    JDefinedClass declare(int mods, TIdentifier identifier, ClassType ctype, Optional<String> name) {
        if (current instanceof Scope.Typey) {
            try {
                Scope.Typey typeyScope = (Scope.Typey) current;
                Type t = typeyScope.declare(mods, identifier, ctype, name);
                global.addType(t);
                current = t.scope;
                scopeStack.push(current);
                //System.out.println("Pushing scope " + current);
                return t.definition;
            } catch (JClassAlreadyExistsException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            Logger.error("Cannot add a type (" + identifier.getText() + ") to a Scope (" + current.getClass().getName() + ") that doesn't allow types!");
            throw new RuntimeException("Invalid Scope for operation!");
        }
    }

    JInvocation resolveInvocation(PName name, ExpressionAdapter.ExpressionParent parent) {
        AName aname = (AName) name;
        return resolveInvocation(aname.getIdentifier(), parent);
    }

    JInvocation resolveInvocation(LinkedList<TIdentifier> ids, ExpressionAdapter.ExpressionParent parent) {
        LinkedList<TIdentifier> prefix = new LinkedList<>(ids);
        final TIdentifier methodName = prefix.pollLast();
        if (prefix.isEmpty()) {
            return parent.invoke(methodName.getText());
        } else {
            JGenerable g = resolveAmbiguous(prefix, new AmbiguousGenerableMapper() {

                @Override
                public JGenerable map(JField f) {
                    return f;
                }

                @Override
                public JGenerable map(Field f) {
                    return f.var;
                }

                @Override
                public JGenerable map(JClass jc) {
                    return jc;
                }
            });
            JInvocation inv = JInvocation.invokeOn(g, methodName.getText());
            parent.addInvocation(inv);
            return inv;
        }
    }

    JMethod method(int mods, TIdentifier identifier, JType resultType) {
        Optional<String> o = Optional.absent();
        return method(mods, identifier, resultType, o);
    }
    
    JMethod method(int mods, TIdentifier identifier, JType resultType, Optional<String> name) {
        if (current instanceof Scope.Methody) {

            Scope.Methody methodyScope = (Scope.Methody) current;
            Method m = methodyScope.method(mods, identifier, resultType, name);
            current = m.scope;
            scopeStack.push(current);
            //System.out.println("Pushing scope " + current);
            return m.definition;
        } else {
            Logger.error("Cannot add a method (" + identifier.getText() + ") to a Scope (" + current.getClass().getName() + ") that doesn't allow method!");
            throw new RuntimeException("Invalid Scope for operation!");
        }
    }

    JMethod constructor(int mods) {
        if (current instanceof Scope.Methody) {

            Scope.Methody methodyScope = (Scope.Methody) current;
            Method m = methodyScope.constructor(mods);
            current = m.scope;
            scopeStack.push(current);
            //System.out.println("Pushing scope " + current);
            return m.definition;
        } else {
            Logger.error("Cannot add a constructor to a Scope (" + current.getClass().getName() + ") that doesn't allow constructors!");
            throw new RuntimeException("Invalid Scope for operation!");
        }
    }

    public void printDeclaredTypes() {
        global.printDeclaredTypes();
    }

    JExpression resolveAmbiguous(PName name, AmbiguousExpressionMapper mapper) {
        AName aname = (AName) name;
        return resolveAmbiguous(aname.getIdentifier(), mapper);
    }

    JExpression resolveAmbiguous(LinkedList<TIdentifier> ids, AmbiguousExpressionMapper mapper) {
        if (ids.isEmpty()) {
            throw new RuntimeException("Fuck you!");
        }
        if (ids.size() == 1) {
            return resolveAmbiguous(ids.peek(), mapper);
        }
        return new JExprProxy(new QualifiedResolver(new LinkedList<TIdentifier>(ids), mapper, current));
    }

    JExpression resolveAmbiguous(TIdentifier id, AmbiguousExpressionMapper mapper) {
        Field f = current.resolveField(id.getText());
        if (f != null) {
            return mapper.map(f);
        }
        JClass jc = current.resolveType(id.getText());
        if (jc != null) {
            return mapper.map(jc);
        }
        return new JExprProxy(new ShortResolver(id, mapper, current));
    }

    private JGenerable resolveAmbiguous(LinkedList<TIdentifier> ids, AmbiguousGenerableMapper mapper) {
        if (ids.isEmpty()) {
            throw new RuntimeException("Fuck you!");
        }
        if (ids.size() == 1) {
            return resolveAmbiguous(ids.peek(), mapper);
        }
        return new JGenProxy(new QualifiedResolver(ids, mapper, current));
    }

    private JGenerable resolveAmbiguous(TIdentifier id, AmbiguousGenerableMapper mapper) {
        Field f = current.resolveField(id.getText());
        if (f != null) {
            return mapper.map(f);
        }
        JClass jc = current.resolveType(id.getText());
        if (jc != null) {
            return mapper.map(jc);
        }
        return new JGenProxy(new ShortResolver(id, mapper, current));
    }

    JDefinedClass anonymousClass(JClass specificHType) {
        JDefinedClass jdc = unit.anonymousClass(specificHType);
        Scope s = new AnonClassScope(jdc, current);
        current = s;
        scopeStack.push(current);
        return jdc;
    }

    private class QualifiedClassResolver implements JClassProxy.ClassResolver {

        private final LinkedList<TIdentifier> prefix = new LinkedList<>();
        private final String name;
        private final Scope referenceScope;

        QualifiedClassResolver(LinkedList<TIdentifier> ids, Scope referenceScope) {
            prefix.addAll(ids);
            name = prefix.pollLast().getText();
            this.referenceScope = referenceScope;
        }

        @Override
        public JClass resolveClass(String name) {
            if (!name.equals(this.name)) {
                throw new RuntimeException("You are not supposed to use this resolver here!");
            }
            // try fully qualified
            Optional<JClass> ojc = global.resolveQualified(nameToString(prefix) + "." + name);
            if (ojc.isPresent()) {
                return ojc.get();
            }
            // try every part separately
            String firstName = prefix.peekFirst().getText();
            JClass jc = referenceScope.resolveType(firstName);
            if (jc == null) {
                Logger.warn(referenceScope.getFile(), prefix.peekFirst(), "Couldn't resolve type " + firstName + " in scope " + referenceScope);
                return null;
            }
            boolean skip = true;
            for (TIdentifier id : prefix) {
                if (skip) {
                    skip = false;
                    continue;
                }
                jc = jc.inner(id.getText());
            }
            return jc;
        }

    }

    private class ShortClassResolver implements JClassProxy.ClassResolver {

        private final TIdentifier id;
        private final String name;
        private final Scope referenceScope;

        ShortClassResolver(TIdentifier id, Scope referenceScope) {
            this.id = id;
            name = id.getText();
            this.referenceScope = referenceScope;
        }

        @Override
        public JClass resolveClass(String name) {
            return referenceScope.resolveType(name);
        }

    }

    private class ShortFieldResolver implements JFieldProxy.FieldResolver {

        private final TIdentifier id;
        private final String name;
        private final Scope referenceScope;

        ShortFieldResolver(TIdentifier id, Scope referenceScope) {
            this.id = id;
            name = id.getText();
            this.referenceScope = referenceScope;
        }

        @Override
        public JField resolveField(String name) {
            Field f = referenceScope.resolveField(name);
            if (f == null) {
                Logger.error(getFile(), id, "Could not resolve field: " + name);
                return null;
            }
            return f.var;
        }
    }

    private class QualifiedFieldResolver implements JFieldProxy.FieldResolver {

        private final LinkedList<TIdentifier> prefix;
        private final String name;
        private final Scope referenceScope;

        QualifiedFieldResolver(LinkedList<TIdentifier> prefix, String fieldName, Scope referenceScope) {
            this.prefix = prefix;
            name = fieldName;
            this.referenceScope = referenceScope;
        }

        @Override
        public JField resolveField(String somename) {
            QualifiedResolver<JField> qres = new QualifiedResolver<>(prefix, new AmbiguousMapper<JField>() {

                @Override
                public JField map(JField f) {
                    return f.ref(name);
                }

                @Override
                public JField map(Field f) {
                    return f.var.ref(name);
                }

                @Override
                public JField map(JClass jc) {
                    return jc.staticRef(name);
                }
            }, referenceScope);
            return qres.resolve();
        }

    }

    private class ShortResolver<E extends JGenerable> implements JGenProxy.Resolver<E> {

        private final TIdentifier id;
        private final AmbiguousMapper<E> mapper;
        private final Scope referenceScope;

        ShortResolver(TIdentifier id, AmbiguousMapper<E> mapper, Scope referenceScope) {
            this.id = id;
            this.mapper = mapper;
            this.referenceScope = referenceScope;
        }

        @Override
        public E resolve() {
            Field f = referenceScope.resolveField(id.getText());
            if (f != null) {
                return mapper.map(f);
            }
            JClass jc = referenceScope.resolveType(id.getText());
            if (jc != null) {
                return mapper.map(jc);
            }
            Logger.error(getFile(), id, "Could not resolve ambiguous name: " + id.getText());
            return null;
        }

    }

    private class QualifiedResolver<E extends JGenerable> implements JGenProxy.Resolver<E> {

        private final LinkedList<TIdentifier> ids;
        private final AmbiguousMapper<E> mapper;
        private final Scope referenceScope;

        QualifiedResolver(LinkedList<TIdentifier> ids, AmbiguousMapper<E> mapper, Scope referenceScope) {
            this.ids = ids;
            this.mapper = mapper;
            this.referenceScope = referenceScope;
        }

        @Override
        public E resolve() {
            // try to resolve everything as a field (since it would override a type or a package)
            String firstName = ids.peekFirst().getText();
            Field f = referenceScope.resolveField(firstName);
            if (f != null) {
                // try to follow all the scopes if possible
//                Field ff = f;
//                boolean skip = true;
//                for (TIdentifier id : ids) {
//                    if (skip) {
//                        skip = false;
//                        continue;
//                    }
//
//                    if ((ff != null) && (ff.declarationScope != null)) {
//                        ff = ff.declarationScope.resolveField(id.getText());
//                    }
//                }
//                if (ff != null) {
//                    return mapper.map(ff);
//                }
                // assume all the rest is fields too (otherwise we'd need to know the exact type everything along the path)
                JField jf = f.var;
                boolean skip = true;
                for (TIdentifier id : ids) {
                    if (skip) {
                        skip = false;
                        continue;
                    }
                    jf = jf.ref(id.getText());
                }
                return mapper.map(jf);
            }

            // otherwise we have to try to find the longest prefix that matches a type
            LinkedList<TIdentifier> prefix = new LinkedList<>(ids);
            LinkedList<TIdentifier> suffix = new LinkedList<>();
            JClass jc = null;
            while (jc == null) {
                if (prefix.size() > 1) {
                    Optional<JClass> ojc = global.resolveQualified(nameToString(prefix));
                    if (ojc != null && ojc.isPresent()) {
                        jc = ojc.get();
                        break;
                    }
                } else if (prefix.size() == 1) {
                    jc = referenceScope.resolveType(prefix.peekFirst().getText());
                    if (jc != null) {
                        break;
                    }
                } else {
                    break;
                }
                suffix.push(prefix.pollLast());
            }
            if (jc != null) {
                JFieldRef ref = null;
                while (!suffix.isEmpty()) {
                    ref = jc.staticRef(suffix.poll().getText());
                }
                if (ref == null) {
                    return mapper.map(jc);
                }
                return mapper.map(ref);
            }
            // out of ideas
            Logger.warn(referenceScope.getFile(), prefix.peekFirst(), "Couldn't resolve ambiguous " + nameToString(ids) + " in scope " + referenceScope);
            return null;
        }

    }

    public static interface AmbiguousMapper<E extends JGenerable> {

        public E map(JField f);

        public E map(Field f);

        public E map(JClass jc);
    }

    public static interface AmbiguousGenerableMapper extends AmbiguousMapper<JGenerable> {
    }

    public static interface AmbiguousExpressionMapper extends AmbiguousMapper<JExpression> {
    }
}
