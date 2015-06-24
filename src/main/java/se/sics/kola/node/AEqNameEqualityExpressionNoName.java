/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AEqNameEqualityExpressionNoName extends PEqualityExpressionNoName
{
    private PEqualityExpressionNoName _equalityExpressionNoName_;
    private TEq _eq_;
    private PName _name_;

    public AEqNameEqualityExpressionNoName()
    {
        // Constructor
    }

    public AEqNameEqualityExpressionNoName(
        @SuppressWarnings("hiding") PEqualityExpressionNoName _equalityExpressionNoName_,
        @SuppressWarnings("hiding") TEq _eq_,
        @SuppressWarnings("hiding") PName _name_)
    {
        // Constructor
        setEqualityExpressionNoName(_equalityExpressionNoName_);

        setEq(_eq_);

        setName(_name_);

    }

    @Override
    public Object clone()
    {
        return new AEqNameEqualityExpressionNoName(
            cloneNode(this._equalityExpressionNoName_),
            cloneNode(this._eq_),
            cloneNode(this._name_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEqNameEqualityExpressionNoName(this);
    }

    public PEqualityExpressionNoName getEqualityExpressionNoName()
    {
        return this._equalityExpressionNoName_;
    }

    public void setEqualityExpressionNoName(PEqualityExpressionNoName node)
    {
        if(this._equalityExpressionNoName_ != null)
        {
            this._equalityExpressionNoName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._equalityExpressionNoName_ = node;
    }

    public TEq getEq()
    {
        return this._eq_;
    }

    public void setEq(TEq node)
    {
        if(this._eq_ != null)
        {
            this._eq_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._eq_ = node;
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
            + toString(this._equalityExpressionNoName_)
            + toString(this._eq_)
            + toString(this._name_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._equalityExpressionNoName_ == child)
        {
            this._equalityExpressionNoName_ = null;
            return;
        }

        if(this._eq_ == child)
        {
            this._eq_ = null;
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
        if(this._equalityExpressionNoName_ == oldChild)
        {
            setEqualityExpressionNoName((PEqualityExpressionNoName) newChild);
            return;
        }

        if(this._eq_ == oldChild)
        {
            setEq((TEq) newChild);
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
