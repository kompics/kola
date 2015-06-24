/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AVolatileModifier extends PModifier
{
    private TVolatileKeyword _volatileKeyword_;

    public AVolatileModifier()
    {
        // Constructor
    }

    public AVolatileModifier(
        @SuppressWarnings("hiding") TVolatileKeyword _volatileKeyword_)
    {
        // Constructor
        setVolatileKeyword(_volatileKeyword_);

    }

    @Override
    public Object clone()
    {
        return new AVolatileModifier(
            cloneNode(this._volatileKeyword_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVolatileModifier(this);
    }

    public TVolatileKeyword getVolatileKeyword()
    {
        return this._volatileKeyword_;
    }

    public void setVolatileKeyword(TVolatileKeyword node)
    {
        if(this._volatileKeyword_ != null)
        {
            this._volatileKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._volatileKeyword_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._volatileKeyword_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._volatileKeyword_ == child)
        {
            this._volatileKeyword_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._volatileKeyword_ == oldChild)
        {
            setVolatileKeyword((TVolatileKeyword) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
