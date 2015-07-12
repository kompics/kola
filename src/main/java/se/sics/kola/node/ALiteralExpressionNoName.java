/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ALiteralExpressionNoName extends PExpressionNoName
{
    private PLiteral _literal_;

    public ALiteralExpressionNoName()
    {
        // Constructor
    }

    public ALiteralExpressionNoName(
        @SuppressWarnings("hiding") PLiteral _literal_)
    {
        // Constructor
        setLiteral(_literal_);

    }

    @Override
    public Object clone()
    {
        return new ALiteralExpressionNoName(
            cloneNode(this._literal_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALiteralExpressionNoName(this);
    }

    public PLiteral getLiteral()
    {
        return this._literal_;
    }

    public void setLiteral(PLiteral node)
    {
        if(this._literal_ != null)
        {
            this._literal_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._literal_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._literal_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._literal_ == child)
        {
            this._literal_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._literal_ == oldChild)
        {
            setLiteral((PLiteral) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}