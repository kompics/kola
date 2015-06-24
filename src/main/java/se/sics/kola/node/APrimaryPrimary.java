/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class APrimaryPrimary extends PPrimary
{
    private PPrimaryNoNewArray _primaryNoNewArray_;

    public APrimaryPrimary()
    {
        // Constructor
    }

    public APrimaryPrimary(
        @SuppressWarnings("hiding") PPrimaryNoNewArray _primaryNoNewArray_)
    {
        // Constructor
        setPrimaryNoNewArray(_primaryNoNewArray_);

    }

    @Override
    public Object clone()
    {
        return new APrimaryPrimary(
            cloneNode(this._primaryNoNewArray_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPrimaryPrimary(this);
    }

    public PPrimaryNoNewArray getPrimaryNoNewArray()
    {
        return this._primaryNoNewArray_;
    }

    public void setPrimaryNoNewArray(PPrimaryNoNewArray node)
    {
        if(this._primaryNoNewArray_ != null)
        {
            this._primaryNoNewArray_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._primaryNoNewArray_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._primaryNoNewArray_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._primaryNoNewArray_ == child)
        {
            this._primaryNoNewArray_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._primaryNoNewArray_ == oldChild)
        {
            setPrimaryNoNewArray((PPrimaryNoNewArray) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
