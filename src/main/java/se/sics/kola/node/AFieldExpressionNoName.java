/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AFieldExpressionNoName extends PExpressionNoName
{
    private PFieldAccess _fieldAccess_;

    public AFieldExpressionNoName()
    {
        // Constructor
    }

    public AFieldExpressionNoName(
        @SuppressWarnings("hiding") PFieldAccess _fieldAccess_)
    {
        // Constructor
        setFieldAccess(_fieldAccess_);

    }

    @Override
    public Object clone()
    {
        return new AFieldExpressionNoName(
            cloneNode(this._fieldAccess_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFieldExpressionNoName(this);
    }

    public PFieldAccess getFieldAccess()
    {
        return this._fieldAccess_;
    }

    public void setFieldAccess(PFieldAccess node)
    {
        if(this._fieldAccess_ != null)
        {
            this._fieldAccess_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._fieldAccess_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._fieldAccess_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._fieldAccess_ == child)
        {
            this._fieldAccess_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._fieldAccess_ == oldChild)
        {
            setFieldAccess((PFieldAccess) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
