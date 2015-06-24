/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ASuper extends PSuper
{
    private TExtendsKeyword _extendsKeyword_;
    private PClassType _classType_;

    public ASuper()
    {
        // Constructor
    }

    public ASuper(
        @SuppressWarnings("hiding") TExtendsKeyword _extendsKeyword_,
        @SuppressWarnings("hiding") PClassType _classType_)
    {
        // Constructor
        setExtendsKeyword(_extendsKeyword_);

        setClassType(_classType_);

    }

    @Override
    public Object clone()
    {
        return new ASuper(
            cloneNode(this._extendsKeyword_),
            cloneNode(this._classType_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASuper(this);
    }

    public TExtendsKeyword getExtendsKeyword()
    {
        return this._extendsKeyword_;
    }

    public void setExtendsKeyword(TExtendsKeyword node)
    {
        if(this._extendsKeyword_ != null)
        {
            this._extendsKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._extendsKeyword_ = node;
    }

    public PClassType getClassType()
    {
        return this._classType_;
    }

    public void setClassType(PClassType node)
    {
        if(this._classType_ != null)
        {
            this._classType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._classType_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._extendsKeyword_)
            + toString(this._classType_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._extendsKeyword_ == child)
        {
            this._extendsKeyword_ = null;
            return;
        }

        if(this._classType_ == child)
        {
            this._classType_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._extendsKeyword_ == oldChild)
        {
            setExtendsKeyword((TExtendsKeyword) newChild);
            return;
        }

        if(this._classType_ == oldChild)
        {
            setClassType((PClassType) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
