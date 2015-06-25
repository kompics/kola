/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AClassPrimaryNoNewArray extends PPrimaryNoNewArray
{
    private PClassName _className_;
    private TDot _dot_;
    private TThisKeyword _thisKeyword_;

    public AClassPrimaryNoNewArray()
    {
        // Constructor
    }

    public AClassPrimaryNoNewArray(
        @SuppressWarnings("hiding") PClassName _className_,
        @SuppressWarnings("hiding") TDot _dot_,
        @SuppressWarnings("hiding") TThisKeyword _thisKeyword_)
    {
        // Constructor
        setClassName(_className_);

        setDot(_dot_);

        setThisKeyword(_thisKeyword_);

    }

    @Override
    public Object clone()
    {
        return new AClassPrimaryNoNewArray(
            cloneNode(this._className_),
            cloneNode(this._dot_),
            cloneNode(this._thisKeyword_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAClassPrimaryNoNewArray(this);
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

    public TDot getDot()
    {
        return this._dot_;
    }

    public void setDot(TDot node)
    {
        if(this._dot_ != null)
        {
            this._dot_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dot_ = node;
    }

    public TThisKeyword getThisKeyword()
    {
        return this._thisKeyword_;
    }

    public void setThisKeyword(TThisKeyword node)
    {
        if(this._thisKeyword_ != null)
        {
            this._thisKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._thisKeyword_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._className_)
            + toString(this._dot_)
            + toString(this._thisKeyword_);
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

        if(this._dot_ == child)
        {
            this._dot_ = null;
            return;
        }

        if(this._thisKeyword_ == child)
        {
            this._thisKeyword_ = null;
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

        if(this._dot_ == oldChild)
        {
            setDot((TDot) newChild);
            return;
        }

        if(this._thisKeyword_ == oldChild)
        {
            setThisKeyword((TThisKeyword) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}