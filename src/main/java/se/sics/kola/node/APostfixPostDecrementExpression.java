/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class APostfixPostDecrementExpression extends PPostDecrementExpression
{
    private PPostfixExpressionNoName _postfixExpressionNoName_;
    private TMinusMinus _minusMinus_;

    public APostfixPostDecrementExpression()
    {
        // Constructor
    }

    public APostfixPostDecrementExpression(
        @SuppressWarnings("hiding") PPostfixExpressionNoName _postfixExpressionNoName_,
        @SuppressWarnings("hiding") TMinusMinus _minusMinus_)
    {
        // Constructor
        setPostfixExpressionNoName(_postfixExpressionNoName_);

        setMinusMinus(_minusMinus_);

    }

    @Override
    public Object clone()
    {
        return new APostfixPostDecrementExpression(
            cloneNode(this._postfixExpressionNoName_),
            cloneNode(this._minusMinus_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPostfixPostDecrementExpression(this);
    }

    public PPostfixExpressionNoName getPostfixExpressionNoName()
    {
        return this._postfixExpressionNoName_;
    }

    public void setPostfixExpressionNoName(PPostfixExpressionNoName node)
    {
        if(this._postfixExpressionNoName_ != null)
        {
            this._postfixExpressionNoName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._postfixExpressionNoName_ = node;
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._postfixExpressionNoName_)
            + toString(this._minusMinus_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._postfixExpressionNoName_ == child)
        {
            this._postfixExpressionNoName_ = null;
            return;
        }

        if(this._minusMinus_ == child)
        {
            this._minusMinus_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._postfixExpressionNoName_ == oldChild)
        {
            setPostfixExpressionNoName((PPostfixExpressionNoName) newChild);
            return;
        }

        if(this._minusMinus_ == oldChild)
        {
            setMinusMinus((TMinusMinus) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}