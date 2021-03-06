/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ASynchronizedModifier extends PModifier
{
    private TSynchronizedKeyword _synchronizedKeyword_;

    public ASynchronizedModifier()
    {
        // Constructor
    }

    public ASynchronizedModifier(
        @SuppressWarnings("hiding") TSynchronizedKeyword _synchronizedKeyword_)
    {
        // Constructor
        setSynchronizedKeyword(_synchronizedKeyword_);

    }

    @Override
    public Object clone()
    {
        return new ASynchronizedModifier(
            cloneNode(this._synchronizedKeyword_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASynchronizedModifier(this);
    }

    public TSynchronizedKeyword getSynchronizedKeyword()
    {
        return this._synchronizedKeyword_;
    }

    public void setSynchronizedKeyword(TSynchronizedKeyword node)
    {
        if(this._synchronizedKeyword_ != null)
        {
            this._synchronizedKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._synchronizedKeyword_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._synchronizedKeyword_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._synchronizedKeyword_ == child)
        {
            this._synchronizedKeyword_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._synchronizedKeyword_ == oldChild)
        {
            setSynchronizedKeyword((TSynchronizedKeyword) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
