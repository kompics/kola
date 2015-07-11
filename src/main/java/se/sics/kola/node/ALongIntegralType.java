/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ALongIntegralType extends PIntegralType
{
    private TLongKeyword _longKeyword_;

    public ALongIntegralType()
    {
        // Constructor
    }

    public ALongIntegralType(
        @SuppressWarnings("hiding") TLongKeyword _longKeyword_)
    {
        // Constructor
        setLongKeyword(_longKeyword_);

    }

    @Override
    public Object clone()
    {
        return new ALongIntegralType(
            cloneNode(this._longKeyword_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALongIntegralType(this);
    }

    public TLongKeyword getLongKeyword()
    {
        return this._longKeyword_;
    }

    public void setLongKeyword(TLongKeyword node)
    {
        if(this._longKeyword_ != null)
        {
            this._longKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._longKeyword_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._longKeyword_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._longKeyword_ == child)
        {
            this._longKeyword_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._longKeyword_ == oldChild)
        {
            setLongKeyword((TLongKeyword) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
