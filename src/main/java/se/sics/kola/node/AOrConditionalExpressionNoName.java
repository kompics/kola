/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AOrConditionalExpressionNoName extends PConditionalExpressionNoName
{
    private PConditionalOrExpressionNoName _conditionalOrExpressionNoName_;

    public AOrConditionalExpressionNoName()
    {
        // Constructor
    }

    public AOrConditionalExpressionNoName(
        @SuppressWarnings("hiding") PConditionalOrExpressionNoName _conditionalOrExpressionNoName_)
    {
        // Constructor
        setConditionalOrExpressionNoName(_conditionalOrExpressionNoName_);

    }

    @Override
    public Object clone()
    {
        return new AOrConditionalExpressionNoName(
            cloneNode(this._conditionalOrExpressionNoName_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAOrConditionalExpressionNoName(this);
    }

    public PConditionalOrExpressionNoName getConditionalOrExpressionNoName()
    {
        return this._conditionalOrExpressionNoName_;
    }

    public void setConditionalOrExpressionNoName(PConditionalOrExpressionNoName node)
    {
        if(this._conditionalOrExpressionNoName_ != null)
        {
            this._conditionalOrExpressionNoName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._conditionalOrExpressionNoName_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._conditionalOrExpressionNoName_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._conditionalOrExpressionNoName_ == child)
        {
            this._conditionalOrExpressionNoName_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._conditionalOrExpressionNoName_ == oldChild)
        {
            setConditionalOrExpressionNoName((PConditionalOrExpressionNoName) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}