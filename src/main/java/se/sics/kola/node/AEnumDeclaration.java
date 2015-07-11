/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import java.util.*;
import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AEnumDeclaration extends PEnumDeclaration
{
    private final LinkedList<PModifier> _modifier_ = new LinkedList<PModifier>();
    private TIdentifier _identifier_;
    private final LinkedList<PInterfaceType> _interfaceType_ = new LinkedList<PInterfaceType>();
    private PEnumBody _enumBody_;

    public AEnumDeclaration()
    {
        // Constructor
    }

    public AEnumDeclaration(
        @SuppressWarnings("hiding") List<?> _modifier_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") List<?> _interfaceType_,
        @SuppressWarnings("hiding") PEnumBody _enumBody_)
    {
        // Constructor
        setModifier(_modifier_);

        setIdentifier(_identifier_);

        setInterfaceType(_interfaceType_);

        setEnumBody(_enumBody_);

    }

    @Override
    public Object clone()
    {
        return new AEnumDeclaration(
            cloneList(this._modifier_),
            cloneNode(this._identifier_),
            cloneList(this._interfaceType_),
            cloneNode(this._enumBody_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEnumDeclaration(this);
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

    public TIdentifier getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
    }

    public LinkedList<PInterfaceType> getInterfaceType()
    {
        return this._interfaceType_;
    }

    public void setInterfaceType(List<?> list)
    {
        for(PInterfaceType e : this._interfaceType_)
        {
            e.parent(null);
        }
        this._interfaceType_.clear();

        for(Object obj_e : list)
        {
            PInterfaceType e = (PInterfaceType) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._interfaceType_.add(e);
        }
    }

    public PEnumBody getEnumBody()
    {
        return this._enumBody_;
    }

    public void setEnumBody(PEnumBody node)
    {
        if(this._enumBody_ != null)
        {
            this._enumBody_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._enumBody_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._modifier_)
            + toString(this._identifier_)
            + toString(this._interfaceType_)
            + toString(this._enumBody_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._modifier_.remove(child))
        {
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._interfaceType_.remove(child))
        {
            return;
        }

        if(this._enumBody_ == child)
        {
            this._enumBody_ = null;
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

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        for(ListIterator<PInterfaceType> i = this._interfaceType_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PInterfaceType) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._enumBody_ == oldChild)
        {
            setEnumBody((PEnumBody) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
