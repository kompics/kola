/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ARequiresKolaKeyword extends PKolaKeyword
{
    private TRequiresKeyword _requiresKeyword_;

    public ARequiresKolaKeyword()
    {
        // Constructor
    }

    public ARequiresKolaKeyword(
        @SuppressWarnings("hiding") TRequiresKeyword _requiresKeyword_)
    {
        // Constructor
        setRequiresKeyword(_requiresKeyword_);

    }

    @Override
    public Object clone()
    {
        return new ARequiresKolaKeyword(
            cloneNode(this._requiresKeyword_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARequiresKolaKeyword(this);
    }

    public TRequiresKeyword getRequiresKeyword()
    {
        return this._requiresKeyword_;
    }

    public void setRequiresKeyword(TRequiresKeyword node)
    {
        if(this._requiresKeyword_ != null)
        {
            this._requiresKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._requiresKeyword_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._requiresKeyword_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._requiresKeyword_ == child)
        {
            this._requiresKeyword_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._requiresKeyword_ == oldChild)
        {
            setRequiresKeyword((TRequiresKeyword) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
