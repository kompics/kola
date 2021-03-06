/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AQmarkExpressionNoName extends PExpressionNoName
{
    private PExpression _cond_;
    private PExpression _true_;
    private PExpression _false_;

    public AQmarkExpressionNoName()
    {
        // Constructor
    }

    public AQmarkExpressionNoName(
        @SuppressWarnings("hiding") PExpression _cond_,
        @SuppressWarnings("hiding") PExpression _true_,
        @SuppressWarnings("hiding") PExpression _false_)
    {
        // Constructor
        setCond(_cond_);

        setTrue(_true_);

        setFalse(_false_);

    }

    @Override
    public Object clone()
    {
        return new AQmarkExpressionNoName(
            cloneNode(this._cond_),
            cloneNode(this._true_),
            cloneNode(this._false_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAQmarkExpressionNoName(this);
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

    public PExpression getTrue()
    {
        return this._true_;
    }

    public void setTrue(PExpression node)
    {
        if(this._true_ != null)
        {
            this._true_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._true_ = node;
    }

    public PExpression getFalse()
    {
        return this._false_;
    }

    public void setFalse(PExpression node)
    {
        if(this._false_ != null)
        {
            this._false_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._false_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._cond_)
            + toString(this._true_)
            + toString(this._false_);
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

        if(this._true_ == child)
        {
            this._true_ = null;
            return;
        }

        if(this._false_ == child)
        {
            this._false_ = null;
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

        if(this._true_ == oldChild)
        {
            setTrue((PExpression) newChild);
            return;
        }

        if(this._false_ == oldChild)
        {
            setFalse((PExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
