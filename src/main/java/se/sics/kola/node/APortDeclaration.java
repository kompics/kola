/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class APortDeclaration extends PPortDeclaration
{
    private PModifiers _modifiers_;
    private TPortKeyword _portKeyword_;
    private TIdentifier _identifier_;
    private PPortBody _portBody_;

    public APortDeclaration()
    {
        // Constructor
    }

    public APortDeclaration(
        @SuppressWarnings("hiding") PModifiers _modifiers_,
        @SuppressWarnings("hiding") TPortKeyword _portKeyword_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") PPortBody _portBody_)
    {
        // Constructor
        setModifiers(_modifiers_);

        setPortKeyword(_portKeyword_);

        setIdentifier(_identifier_);

        setPortBody(_portBody_);

    }

    @Override
    public Object clone()
    {
        return new APortDeclaration(
            cloneNode(this._modifiers_),
            cloneNode(this._portKeyword_),
            cloneNode(this._identifier_),
            cloneNode(this._portBody_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPortDeclaration(this);
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

    public TPortKeyword getPortKeyword()
    {
        return this._portKeyword_;
    }

    public void setPortKeyword(TPortKeyword node)
    {
        if(this._portKeyword_ != null)
        {
            this._portKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._portKeyword_ = node;
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

    public PPortBody getPortBody()
    {
        return this._portBody_;
    }

    public void setPortBody(PPortBody node)
    {
        if(this._portBody_ != null)
        {
            this._portBody_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._portBody_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._modifiers_)
            + toString(this._portKeyword_)
            + toString(this._identifier_)
            + toString(this._portBody_);
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

        if(this._portKeyword_ == child)
        {
            this._portKeyword_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._portBody_ == child)
        {
            this._portBody_ = null;
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

        if(this._portKeyword_ == oldChild)
        {
            setPortKeyword((TPortKeyword) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        if(this._portBody_ == oldChild)
        {
            setPortBody((PPortBody) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}