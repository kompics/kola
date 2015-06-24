/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AIncrementPostfixExpressionNoName extends PPostfixExpressionNoName
{
    private PPostIncrementExpression _postIncrementExpression_;

    public AIncrementPostfixExpressionNoName()
    {
        // Constructor
    }

    public AIncrementPostfixExpressionNoName(
        @SuppressWarnings("hiding") PPostIncrementExpression _postIncrementExpression_)
    {
        // Constructor
        setPostIncrementExpression(_postIncrementExpression_);

    }

    @Override
    public Object clone()
    {
        return new AIncrementPostfixExpressionNoName(
            cloneNode(this._postIncrementExpression_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIncrementPostfixExpressionNoName(this);
    }

    public PPostIncrementExpression getPostIncrementExpression()
    {
        return this._postIncrementExpression_;
    }

    public void setPostIncrementExpression(PPostIncrementExpression node)
    {
        if(this._postIncrementExpression_ != null)
        {
            this._postIncrementExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._postIncrementExpression_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._postIncrementExpression_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._postIncrementExpression_ == child)
        {
            this._postIncrementExpression_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._postIncrementExpression_ == oldChild)
        {
            setPostIncrementExpression((PPostIncrementExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
