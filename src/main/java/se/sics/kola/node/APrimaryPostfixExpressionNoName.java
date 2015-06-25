/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class APrimaryPostfixExpressionNoName extends PPostfixExpressionNoName
{
    private PPrimary _primary_;

    public APrimaryPostfixExpressionNoName()
    {
        // Constructor
    }

    public APrimaryPostfixExpressionNoName(
        @SuppressWarnings("hiding") PPrimary _primary_)
    {
        // Constructor
        setPrimary(_primary_);

    }

    @Override
    public Object clone()
    {
        return new APrimaryPostfixExpressionNoName(
            cloneNode(this._primary_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPrimaryPostfixExpressionNoName(this);
    }

    public PPrimary getPrimary()
    {
        return this._primary_;
    }

    public void setPrimary(PPrimary node)
    {
        if(this._primary_ != null)
        {
            this._primary_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._primary_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._primary_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._primary_ == child)
        {
            this._primary_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._primary_ == oldChild)
        {
            setPrimary((PPrimary) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}