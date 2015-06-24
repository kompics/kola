/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AArrayPrimaryNoNewArray extends PPrimaryNoNewArray
{
    private PArrayAccess _arrayAccess_;

    public AArrayPrimaryNoNewArray()
    {
        // Constructor
    }

    public AArrayPrimaryNoNewArray(
        @SuppressWarnings("hiding") PArrayAccess _arrayAccess_)
    {
        // Constructor
        setArrayAccess(_arrayAccess_);

    }

    @Override
    public Object clone()
    {
        return new AArrayPrimaryNoNewArray(
            cloneNode(this._arrayAccess_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArrayPrimaryNoNewArray(this);
    }

    public PArrayAccess getArrayAccess()
    {
        return this._arrayAccess_;
    }

    public void setArrayAccess(PArrayAccess node)
    {
        if(this._arrayAccess_ != null)
        {
            this._arrayAccess_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._arrayAccess_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._arrayAccess_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._arrayAccess_ == child)
        {
            this._arrayAccess_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._arrayAccess_ == oldChild)
        {
            setArrayAccess((PArrayAccess) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
