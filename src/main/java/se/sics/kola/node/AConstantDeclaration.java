/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import java.util.*;
import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AConstantDeclaration extends PConstantDeclaration
{
    private final LinkedList<PModifier> _modifier_ = new LinkedList<PModifier>();
    private PType _type_;
    private final LinkedList<PVariableDeclarator> _variableDeclarator_ = new LinkedList<PVariableDeclarator>();

    public AConstantDeclaration()
    {
        // Constructor
    }

    public AConstantDeclaration(
        @SuppressWarnings("hiding") List<?> _modifier_,
        @SuppressWarnings("hiding") PType _type_,
        @SuppressWarnings("hiding") List<?> _variableDeclarator_)
    {
        // Constructor
        setModifier(_modifier_);

        setType(_type_);

        setVariableDeclarator(_variableDeclarator_);

    }

    @Override
    public Object clone()
    {
        return new AConstantDeclaration(
            cloneList(this._modifier_),
            cloneNode(this._type_),
            cloneList(this._variableDeclarator_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAConstantDeclaration(this);
    }

    public LinkedList<PModifier> getModifier()
    {
        return this._modifier_;
    }

    public void setModifier(List<?> list)
    {
        for(PModifier e : this._modifier_)
        {
            e.parent(null);
        }
        this._modifier_.clear();

        for(Object obj_e : list)
        {
            PModifier e = (PModifier) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._modifier_.add(e);
        }
    }

    public PType getType()
    {
        return this._type_;
    }

    public void setType(PType node)
    {
        if(this._type_ != null)
        {
            this._type_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._type_ = node;
    }

    public LinkedList<PVariableDeclarator> getVariableDeclarator()
    {
        return this._variableDeclarator_;
    }

    public void setVariableDeclarator(List<?> list)
    {
        for(PVariableDeclarator e : this._variableDeclarator_)
        {
            e.parent(null);
        }
        this._variableDeclarator_.clear();

        for(Object obj_e : list)
        {
            PVariableDeclarator e = (PVariableDeclarator) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._variableDeclarator_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._modifier_)
            + toString(this._type_)
            + toString(this._variableDeclarator_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._modifier_.remove(child))
        {
            return;
        }

        if(this._type_ == child)
        {
            this._type_ = null;
            return;
        }

        if(this._variableDeclarator_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PModifier> i = this._modifier_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PModifier) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._type_ == oldChild)
        {
            setType((PType) newChild);
            return;
        }

        for(ListIterator<PVariableDeclarator> i = this._variableDeclarator_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PVariableDeclarator) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
