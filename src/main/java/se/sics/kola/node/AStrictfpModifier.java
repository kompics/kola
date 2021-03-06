/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AStrictfpModifier extends PModifier
{
    private TStrictfpKeyword _strictfpKeyword_;

    public AStrictfpModifier()
    {
        // Constructor
    }

    public AStrictfpModifier(
        @SuppressWarnings("hiding") TStrictfpKeyword _strictfpKeyword_)
    {
        // Constructor
        setStrictfpKeyword(_strictfpKeyword_);

    }

    @Override
    public Object clone()
    {
        return new AStrictfpModifier(
            cloneNode(this._strictfpKeyword_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAStrictfpModifier(this);
    }

    public TStrictfpKeyword getStrictfpKeyword()
    {
        return this._strictfpKeyword_;
    }

    public void setStrictfpKeyword(TStrictfpKeyword node)
    {
        if(this._strictfpKeyword_ != null)
        {
            this._strictfpKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._strictfpKeyword_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._strictfpKeyword_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._strictfpKeyword_ == child)
        {
            this._strictfpKeyword_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._strictfpKeyword_ == oldChild)
        {
            setStrictfpKeyword((TStrictfpKeyword) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
