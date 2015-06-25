/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ANormalInterfaceDeclaration extends PNormalInterfaceDeclaration
{
    private PModifiers _modifiers_;
    private TInterfaceKeyword _interfaceKeyword_;
    private TIdentifier _identifier_;
    private PTypeParameters _typeParameters_;
    private PExtendsInterfaces _extendsInterfaces_;
    private PInterfaceBody _interfaceBody_;

    public ANormalInterfaceDeclaration()
    {
        // Constructor
    }

    public ANormalInterfaceDeclaration(
        @SuppressWarnings("hiding") PModifiers _modifiers_,
        @SuppressWarnings("hiding") TInterfaceKeyword _interfaceKeyword_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") PTypeParameters _typeParameters_,
        @SuppressWarnings("hiding") PExtendsInterfaces _extendsInterfaces_,
        @SuppressWarnings("hiding") PInterfaceBody _interfaceBody_)
    {
        // Constructor
        setModifiers(_modifiers_);

        setInterfaceKeyword(_interfaceKeyword_);

        setIdentifier(_identifier_);

        setTypeParameters(_typeParameters_);

        setExtendsInterfaces(_extendsInterfaces_);

        setInterfaceBody(_interfaceBody_);

    }

    @Override
    public Object clone()
    {
        return new ANormalInterfaceDeclaration(
            cloneNode(this._modifiers_),
            cloneNode(this._interfaceKeyword_),
            cloneNode(this._identifier_),
            cloneNode(this._typeParameters_),
            cloneNode(this._extendsInterfaces_),
            cloneNode(this._interfaceBody_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANormalInterfaceDeclaration(this);
    }

    public PModifiers getModifiers()
    {
        return this._modifiers_;
    }

    public void setModifiers(PModifiers node)
    {
        if(this._modifiers_ != null)
        {
            this._modifiers_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._modifiers_ = node;
    }

    public TInterfaceKeyword getInterfaceKeyword()
    {
        return this._interfaceKeyword_;
    }

    public void setInterfaceKeyword(TInterfaceKeyword node)
    {
        if(this._interfaceKeyword_ != null)
        {
            this._interfaceKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._interfaceKeyword_ = node;
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

    public PTypeParameters getTypeParameters()
    {
        return this._typeParameters_;
    }

    public void setTypeParameters(PTypeParameters node)
    {
        if(this._typeParameters_ != null)
        {
            this._typeParameters_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._typeParameters_ = node;
    }

    public PExtendsInterfaces getExtendsInterfaces()
    {
        return this._extendsInterfaces_;
    }

    public void setExtendsInterfaces(PExtendsInterfaces node)
    {
        if(this._extendsInterfaces_ != null)
        {
            this._extendsInterfaces_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._extendsInterfaces_ = node;
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
            + toString(this._modifiers_)
            + toString(this._interfaceKeyword_)
            + toString(this._identifier_)
            + toString(this._typeParameters_)
            + toString(this._extendsInterfaces_)
            + toString(this._interfaceBody_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._modifiers_ == child)
        {
            this._modifiers_ = null;
            return;
        }

        if(this._interfaceKeyword_ == child)
        {
            this._interfaceKeyword_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._typeParameters_ == child)
        {
            this._typeParameters_ = null;
            return;
        }

        if(this._extendsInterfaces_ == child)
        {
            this._extendsInterfaces_ = null;
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
        if(this._modifiers_ == oldChild)
        {
            setModifiers((PModifiers) newChild);
            return;
        }

        if(this._interfaceKeyword_ == oldChild)
        {
            setInterfaceKeyword((TInterfaceKeyword) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        if(this._typeParameters_ == oldChild)
        {
            setTypeParameters((PTypeParameters) newChild);
            return;
        }

        if(this._extendsInterfaces_ == oldChild)
        {
            setExtendsInterfaces((PExtendsInterfaces) newChild);
            return;
        }

        if(this._interfaceBody_ == oldChild)
        {
            setInterfaceBody((PInterfaceBody) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}