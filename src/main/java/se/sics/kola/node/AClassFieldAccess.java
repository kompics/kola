/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AClassFieldAccess extends PFieldAccess
{
    private PClassName _className_;
    private TIdentifier _identifier_;

    public AClassFieldAccess()
    {
        // Constructor
    }

    public AClassFieldAccess(
        @SuppressWarnings("hiding") PClassName _className_,
        @SuppressWarnings("hiding") TIdentifier _identifier_)
    {
        // Constructor
        setClassName(_className_);

        setIdentifier(_identifier_);

    }

    @Override
    public Object clone()
    {
        return new AClassFieldAccess(
            cloneNode(this._className_),
            cloneNode(this._identifier_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAClassFieldAccess(this);
    }

    public PClassName getClassName()
    {
        return this._className_;
    }

    public void setClassName(PClassName node)
    {
        if(this._className_ != null)
        {
            this._className_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._className_ = node;
    }

    public TIdentifier getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._className_)
            + toString(this._identifier_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._className_ == child)
        {
            this._className_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._className_ == oldChild)
        {
            setClassName((PClassName) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
