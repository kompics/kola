/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class APackageDeclaration extends PPackageDeclaration
{
    private PModifiers _modifiers_;
    private TPackageKeyword _packageKeyword_;
    private PName _name_;
    private TSemi _semi_;

    public APackageDeclaration()
    {
        // Constructor
    }

    public APackageDeclaration(
        @SuppressWarnings("hiding") PModifiers _modifiers_,
        @SuppressWarnings("hiding") TPackageKeyword _packageKeyword_,
        @SuppressWarnings("hiding") PName _name_,
        @SuppressWarnings("hiding") TSemi _semi_)
    {
        // Constructor
        setModifiers(_modifiers_);

        setPackageKeyword(_packageKeyword_);

        setName(_name_);

        setSemi(_semi_);

    }

    @Override
    public Object clone()
    {
        return new APackageDeclaration(
            cloneNode(this._modifiers_),
            cloneNode(this._packageKeyword_),
            cloneNode(this._name_),
            cloneNode(this._semi_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPackageDeclaration(this);
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

    public TPackageKeyword getPackageKeyword()
    {
        return this._packageKeyword_;
    }

    public void setPackageKeyword(TPackageKeyword node)
    {
        if(this._packageKeyword_ != null)
        {
            this._packageKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._packageKeyword_ = node;
    }

    public PName getName()
    {
        return this._name_;
    }

    public void setName(PName node)
    {
        if(this._name_ != null)
        {
            this._name_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._name_ = node;
    }

    public TSemi getSemi()
    {
        return this._semi_;
    }

    public void setSemi(TSemi node)
    {
        if(this._semi_ != null)
        {
            this._semi_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semi_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._modifiers_)
            + toString(this._packageKeyword_)
            + toString(this._name_)
            + toString(this._semi_);
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

        if(this._packageKeyword_ == child)
        {
            this._packageKeyword_ = null;
            return;
        }

        if(this._name_ == child)
        {
            this._name_ = null;
            return;
        }

        if(this._semi_ == child)
        {
            this._semi_ = null;
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

        if(this._packageKeyword_ == oldChild)
        {
            setPackageKeyword((TPackageKeyword) newChild);
            return;
        }

        if(this._name_ == oldChild)
        {
            setName((PName) newChild);
            return;
        }

        if(this._semi_ == oldChild)
        {
            setSemi((TSemi) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
