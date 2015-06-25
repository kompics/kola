/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AGteqRelationalExpressionNoNameNoInstanceof extends PRelationalExpressionNoNameNoInstanceof
{
    private PShiftExpressionNoName _shiftExpressionNoName_;
    private TGteq _gteq_;
    private PRelationalExpressionNoNameNoInstanceof _relationalExpressionNoNameNoInstanceof_;

    public AGteqRelationalExpressionNoNameNoInstanceof()
    {
        // Constructor
    }

    public AGteqRelationalExpressionNoNameNoInstanceof(
        @SuppressWarnings("hiding") PShiftExpressionNoName _shiftExpressionNoName_,
        @SuppressWarnings("hiding") TGteq _gteq_,
        @SuppressWarnings("hiding") PRelationalExpressionNoNameNoInstanceof _relationalExpressionNoNameNoInstanceof_)
    {
        // Constructor
        setShiftExpressionNoName(_shiftExpressionNoName_);

        setGteq(_gteq_);

        setRelationalExpressionNoNameNoInstanceof(_relationalExpressionNoNameNoInstanceof_);

    }

    @Override
    public Object clone()
    {
        return new AGteqRelationalExpressionNoNameNoInstanceof(
            cloneNode(this._shiftExpressionNoName_),
            cloneNode(this._gteq_),
            cloneNode(this._relationalExpressionNoNameNoInstanceof_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAGteqRelationalExpressionNoNameNoInstanceof(this);
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

    public TGteq getGteq()
    {
        return this._gteq_;
    }

    public void setGteq(TGteq node)
    {
        if(this._gteq_ != null)
        {
            this._gteq_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._gteq_ = node;
    }

    public PRelationalExpressionNoNameNoInstanceof getRelationalExpressionNoNameNoInstanceof()
    {
        return this._relationalExpressionNoNameNoInstanceof_;
    }

    public void setRelationalExpressionNoNameNoInstanceof(PRelationalExpressionNoNameNoInstanceof node)
    {
        if(this._relationalExpressionNoNameNoInstanceof_ != null)
        {
            this._relationalExpressionNoNameNoInstanceof_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._relationalExpressionNoNameNoInstanceof_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._shiftExpressionNoName_)
            + toString(this._gteq_)
            + toString(this._relationalExpressionNoNameNoInstanceof_);
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

        if(this._gteq_ == child)
        {
            this._gteq_ = null;
            return;
        }

        if(this._relationalExpressionNoNameNoInstanceof_ == child)
        {
            this._relationalExpressionNoNameNoInstanceof_ = null;
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

        if(this._gteq_ == oldChild)
        {
            setGteq((TGteq) newChild);
            return;
        }

        if(this._relationalExpressionNoNameNoInstanceof_ == oldChild)
        {
            setRelationalExpressionNoNameNoInstanceof((PRelationalExpressionNoNameNoInstanceof) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}