/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ARelationalEqualityExpressionNoName extends PEqualityExpressionNoName
{
    private PRelationalExpressionNoName _relationalExpressionNoName_;

    public ARelationalEqualityExpressionNoName()
    {
        // Constructor
    }

    public ARelationalEqualityExpressionNoName(
        @SuppressWarnings("hiding") PRelationalExpressionNoName _relationalExpressionNoName_)
    {
        // Constructor
        setRelationalExpressionNoName(_relationalExpressionNoName_);

    }

    @Override
    public Object clone()
    {
        return new ARelationalEqualityExpressionNoName(
            cloneNode(this._relationalExpressionNoName_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARelationalEqualityExpressionNoName(this);
    }

    public PRelationalExpressionNoName getRelationalExpressionNoName()
    {
        return this._relationalExpressionNoName_;
    }

    public void setRelationalExpressionNoName(PRelationalExpressionNoName node)
    {
        if(this._relationalExpressionNoName_ != null)
        {
            this._relationalExpressionNoName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._relationalExpressionNoName_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._relationalExpressionNoName_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._relationalExpressionNoName_ == child)
        {
            this._relationalExpressionNoName_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._relationalExpressionNoName_ == oldChild)
        {
            setRelationalExpressionNoName((PRelationalExpressionNoName) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
