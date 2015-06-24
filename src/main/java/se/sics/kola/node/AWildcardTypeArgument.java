/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AWildcardTypeArgument extends PTypeArgument
{
    private PWildcard _wildcard_;

    public AWildcardTypeArgument()
    {
        // Constructor
    }

    public AWildcardTypeArgument(
        @SuppressWarnings("hiding") PWildcard _wildcard_)
    {
        // Constructor
        setWildcard(_wildcard_);

    }

    @Override
    public Object clone()
    {
        return new AWildcardTypeArgument(
            cloneNode(this._wildcard_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAWildcardTypeArgument(this);
    }

    public PWildcard getWildcard()
    {
        return this._wildcard_;
    }

    public void setWildcard(PWildcard node)
    {
        if(this._wildcard_ != null)
        {
            this._wildcard_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._wildcard_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._wildcard_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._wildcard_ == child)
        {
            this._wildcard_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._wildcard_ == oldChild)
        {
            setWildcard((PWildcard) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
