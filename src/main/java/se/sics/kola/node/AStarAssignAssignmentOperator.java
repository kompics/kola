/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AStarAssignAssignmentOperator extends PAssignmentOperator
{
    private TStarAssign _starAssign_;

    public AStarAssignAssignmentOperator()
    {
        // Constructor
    }

    public AStarAssignAssignmentOperator(
        @SuppressWarnings("hiding") TStarAssign _starAssign_)
    {
        // Constructor
        setStarAssign(_starAssign_);

    }

    @Override
    public Object clone()
    {
        return new AStarAssignAssignmentOperator(
            cloneNode(this._starAssign_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAStarAssignAssignmentOperator(this);
    }

    public TStarAssign getStarAssign()
    {
        return this._starAssign_;
    }

    public void setStarAssign(TStarAssign node)
    {
        if(this._starAssign_ != null)
        {
            this._starAssign_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._starAssign_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._starAssign_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._starAssign_ == child)
        {
            this._starAssign_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._starAssign_ == oldChild)
        {
            setStarAssign((TStarAssign) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}