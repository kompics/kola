/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AShiftRelationalExpressionNoNameNoInstanceof extends PRelationalExpressionNoNameNoInstanceof
{
    private PShiftExpressionNoName _shiftExpressionNoName_;

    public AShiftRelationalExpressionNoNameNoInstanceof()
    {
        // Constructor
    }

    public AShiftRelationalExpressionNoNameNoInstanceof(
        @SuppressWarnings("hiding") PShiftExpressionNoName _shiftExpressionNoName_)
    {
        // Constructor
        setShiftExpressionNoName(_shiftExpressionNoName_);

    }

    @Override
    public Object clone()
    {
        return new AShiftRelationalExpressionNoNameNoInstanceof(
            cloneNode(this._shiftExpressionNoName_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAShiftRelationalExpressionNoNameNoInstanceof(this);
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._shiftExpressionNoName_);
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

        throw new RuntimeException("Not a child.");
    }
}
