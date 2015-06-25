/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AModifiersModifiers extends PModifiers
{
    private PModifiers _modifiers_;
    private PModifier _modifier_;

    public AModifiersModifiers()
    {
        // Constructor
    }

    public AModifiersModifiers(
        @SuppressWarnings("hiding") PModifiers _modifiers_,
        @SuppressWarnings("hiding") PModifier _modifier_)
    {
        // Constructor
        setModifiers(_modifiers_);

        setModifier(_modifier_);

    }

    @Override
    public Object clone()
    {
        return new AModifiersModifiers(
            cloneNode(this._modifiers_),
            cloneNode(this._modifier_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAModifiersModifiers(this);
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

    public PModifier getModifier()
    {
        return this._modifier_;
    }

    public void setModifier(PModifier node)
    {
        if(this._modifier_ != null)
        {
            this._modifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._modifier_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._modifiers_)
            + toString(this._modifier_);
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

        if(this._modifier_ == child)
        {
            this._modifier_ = null;
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

        if(this._modifier_ == oldChild)
        {
            setModifier((PModifier) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}