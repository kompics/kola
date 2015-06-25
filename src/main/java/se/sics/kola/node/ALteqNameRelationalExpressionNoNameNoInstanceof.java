/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ALteqNameRelationalExpressionNoNameNoInstanceof extends PRelationalExpressionNoNameNoInstanceof
{
    private PShiftExpressionNoName _shiftExpressionNoName_;
    private TLteq _lteq_;
    private PName _name_;

    public ALteqNameRelationalExpressionNoNameNoInstanceof()
    {
        // Constructor
    }

    public ALteqNameRelationalExpressionNoNameNoInstanceof(
        @SuppressWarnings("hiding") PShiftExpressionNoName _shiftExpressionNoName_,
        @SuppressWarnings("hiding") TLteq _lteq_,
        @SuppressWarnings("hiding") PName _name_)
    {
        // Constructor
        setShiftExpressionNoName(_shiftExpressionNoName_);

        setLteq(_lteq_);

        setName(_name_);

    }

    @Override
    public Object clone()
    {
        return new ALteqNameRelationalExpressionNoNameNoInstanceof(
            cloneNode(this._shiftExpressionNoName_),
            cloneNode(this._lteq_),
            cloneNode(this._name_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALteqNameRelationalExpressionNoNameNoInstanceof(this);
    }

    public PShiftExpressionNoName getShiftExpressionNoName()
    {
        return this._shiftExpressionNoName_;
    }

    public void setShiftExpressionNoName(PShiftExpressionNoName node)
    {
        if(this._shiftExpressionNoName_ != null)
        {
            this._shiftExpressionNoName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._shiftExpressionNoName_ = node;
    }

    public TLteq getLteq()
    {
        return this._lteq_;
    }

    public void setLteq(TLteq node)
    {
        if(this._lteq_ != null)
        {
            this._lteq_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lteq_ = node;
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
            + toString(this._shiftExpressionNoName_)
            + toString(this._lteq_)
            + toString(this._name_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._shiftExpressionNoName_ == child)
        {
            this._shiftExpressionNoName_ = null;
            return;
        }

        if(this._lteq_ == child)
        {
            this._lteq_ = null;
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
        if(this._shiftExpressionNoName_ == oldChild)
        {
            setShiftExpressionNoName((PShiftExpressionNoName) newChild);
            return;
        }

        if(this._lteq_ == oldChild)
        {
            setLteq((TLteq) newChild);
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