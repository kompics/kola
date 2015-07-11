/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AExpressionReturnStatement extends PReturnStatement
{
    private PExpression _returnValue_;

    public AExpressionReturnStatement()
    {
        // Constructor
    }

    public AExpressionReturnStatement(
        @SuppressWarnings("hiding") PExpression _returnValue_)
    {
        // Constructor
        setReturnValue(_returnValue_);

    }

    @Override
    public Object clone()
    {
        return new AExpressionReturnStatement(
            cloneNode(this._returnValue_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpressionReturnStatement(this);
    }

    public PExpression getReturnValue()
    {
        return this._returnValue_;
    }

    public void setReturnValue(PExpression node)
    {
        if(this._returnValue_ != null)
        {
            this._returnValue_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._returnValue_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._returnValue_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._returnValue_ == child)
        {
            this._returnValue_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._returnValue_ == oldChild)
        {
            setReturnValue((PExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
