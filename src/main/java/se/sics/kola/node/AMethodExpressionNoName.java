/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AMethodExpressionNoName extends PExpressionNoName
{
    private PMethodInvocation _methodInvocation_;

    public AMethodExpressionNoName()
    {
        // Constructor
    }

    public AMethodExpressionNoName(
        @SuppressWarnings("hiding") PMethodInvocation _methodInvocation_)
    {
        // Constructor
        setMethodInvocation(_methodInvocation_);

    }

    @Override
    public Object clone()
    {
        return new AMethodExpressionNoName(
            cloneNode(this._methodInvocation_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMethodExpressionNoName(this);
    }

    public PMethodInvocation getMethodInvocation()
    {
        return this._methodInvocation_;
    }

    public void setMethodInvocation(PMethodInvocation node)
    {
        if(this._methodInvocation_ != null)
        {
            this._methodInvocation_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._methodInvocation_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._methodInvocation_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._methodInvocation_ == child)
        {
            this._methodInvocation_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._methodInvocation_ == oldChild)
        {
            setMethodInvocation((PMethodInvocation) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}