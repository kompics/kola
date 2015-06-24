/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AEqualityAndExpressionNoName extends PAndExpressionNoName
{
    private PEqualityExpressionNoName _equalityExpressionNoName_;

    public AEqualityAndExpressionNoName()
    {
        // Constructor
    }

    public AEqualityAndExpressionNoName(
        @SuppressWarnings("hiding") PEqualityExpressionNoName _equalityExpressionNoName_)
    {
        // Constructor
        setEqualityExpressionNoName(_equalityExpressionNoName_);

    }

    @Override
    public Object clone()
    {
        return new AEqualityAndExpressionNoName(
            cloneNode(this._equalityExpressionNoName_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEqualityAndExpressionNoName(this);
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._equalityExpressionNoName_);
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

        throw new RuntimeException("Not a child.");
    }
}
