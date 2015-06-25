/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ANamePreDecrementExpression extends PPreDecrementExpression
{
    private TMinusMinus _minusMinus_;
    private PName _name_;

    public ANamePreDecrementExpression()
    {
        // Constructor
    }

    public ANamePreDecrementExpression(
        @SuppressWarnings("hiding") TMinusMinus _minusMinus_,
        @SuppressWarnings("hiding") PName _name_)
    {
        // Constructor
        setMinusMinus(_minusMinus_);

        setName(_name_);

    }

    @Override
    public Object clone()
    {
        return new ANamePreDecrementExpression(
            cloneNode(this._minusMinus_),
            cloneNode(this._name_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANamePreDecrementExpression(this);
    }

    public TMinusMinus getMinusMinus()
    {
        return this._minusMinus_;
    }

    public void setMinusMinus(TMinusMinus node)
    {
        if(this._minusMinus_ != null)
        {
            this._minusMinus_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._minusMinus_ = node;
    }

    public PName getName()
    {
        return this._name_;
    }

    public void setName(PName node)
    {
        if(this._name_ != null)
        {
            this._name_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._name_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._minusMinus_)
            + toString(this._name_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._minusMinus_ == child)
        {
            this._minusMinus_ = null;
            return;
        }

        if(this._name_ == child)
        {
            this._name_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._minusMinus_ == oldChild)
        {
            setMinusMinus((TMinusMinus) newChild);
            return;
        }

        if(this._name_ == oldChild)
        {
            setName((PName) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}