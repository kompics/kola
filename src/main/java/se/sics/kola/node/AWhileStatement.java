/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AWhileStatement extends PWhileStatement
{
    private PExpression _cond_;
    private PStatement _do_;

    public AWhileStatement()
    {
        // Constructor
    }

    public AWhileStatement(
        @SuppressWarnings("hiding") PExpression _cond_,
        @SuppressWarnings("hiding") PStatement _do_)
    {
        // Constructor
        setCond(_cond_);

        setDo(_do_);

    }

    @Override
    public Object clone()
    {
        return new AWhileStatement(
            cloneNode(this._cond_),
            cloneNode(this._do_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAWhileStatement(this);
    }

    public PExpression getCond()
    {
        return this._cond_;
    }

    public void setCond(PExpression node)
    {
        if(this._cond_ != null)
        {
            this._cond_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._cond_ = node;
    }

    public PStatement getDo()
    {
        return this._do_;
    }

    public void setDo(PStatement node)
    {
        if(this._do_ != null)
        {
            this._do_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._do_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._cond_)
            + toString(this._do_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._cond_ == child)
        {
            this._cond_ = null;
            return;
        }

        if(this._do_ == child)
        {
            this._do_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._cond_ == oldChild)
        {
            setCond((PExpression) newChild);
            return;
        }

        if(this._do_ == oldChild)
        {
            setDo((PStatement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
