/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import java.util.*;
import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ANormalInterfaceDeclaration extends PNormalInterfaceDeclaration
{
    private final LinkedList<PModifier> _modifier_ = new LinkedList<PModifier>();
    private TIdentifier _identifier_;
    private final LinkedList<PTypeParameter> _typeParameter_ = new LinkedList<PTypeParameter>();
    private final LinkedList<PInterfaceType> _extendsInterfaces_ = new LinkedList<PInterfaceType>();
    private PInterfaceBody _interfaceBody_;

    public ANormalInterfaceDeclaration()
    {
        // Constructor
    }

    public ANormalInterfaceDeclaration(
        @SuppressWarnings("hiding") List<?> _modifier_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") List<?> _typeParameter_,
        @SuppressWarnings("hiding") List<?> _extendsInterfaces_,
        @SuppressWarnings("hiding") PInterfaceBody _interfaceBody_)
    {
        // Constructor
        setModifier(_modifier_);

        setIdentifier(_identifier_);

        setTypeParameter(_typeParameter_);

        setExtendsInterfaces(_extendsInterfaces_);

        setInterfaceBody(_interfaceBody_);

    }

    @Override
    public Object clone()
    {
        return new ANormalInterfaceDeclaration(
            cloneList(this._modifier_),
            cloneNode(this._identifier_),
            cloneList(this._typeParameter_),
            cloneList(this._extendsInterfaces_),
            cloneNode(this._interfaceBody_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANormalInterfaceDeclaration(this);
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

    public LinkedList<PTypeParameter> getTypeParameter()
    {
        return this._typeParameter_;
    }

    public void setTypeParameter(List<?> list)
    {
        for(PTypeParameter e : this._typeParameter_)
        {
            e.parent(null);
        }
        this._typeParameter_.clear();

        for(Object obj_e : list)
        {
            PTypeParameter e = (PTypeParameter) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._typeParameter_.add(e);
        }
    }

    public LinkedList<PInterfaceType> getExtendsInterfaces()
    {
        return this._extendsInterfaces_;
    }

    public void setExtendsInterfaces(List<?> list)
    {
        for(PInterfaceType e : this._extendsInterfaces_)
        {
            e.parent(null);
        }
        this._extendsInterfaces_.clear();

        for(Object obj_e : list)
        {
            PInterfaceType e = (PInterfaceType) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._extendsInterfaces_.add(e);
        }
    }

    public PInterfaceBody getInterfaceBody()
    {
        return this._interfaceBody_;
    }

    public void setInterfaceBody(PInterfaceBody node)
    {
        if(this._interfaceBody_ != null)
        {
            this._interfaceBody_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._interfaceBody_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._modifier_)
            + toString(this._identifier_)
            + toString(this._typeParameter_)
            + toString(this._extendsInterfaces_)
            + toString(this._interfaceBody_);
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

        if(this._typeParameter_.remove(child))
        {
            return;
        }

        if(this._extendsInterfaces_.remove(child))
        {
            return;
        }

        if(this._interfaceBody_ == child)
        {
            this._interfaceBody_ = null;
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

        for(ListIterator<PTypeParameter> i = this._typeParameter_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PTypeParameter) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator<PInterfaceType> i = this._extendsInterfaces_.listIterator(); i.hasNext();)
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

        if(this._interfaceBody_ == oldChild)
        {
            setInterfaceBody((PInterfaceBody) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}