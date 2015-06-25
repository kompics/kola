/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AExpressionNoName extends PExpressionNoName
{
    private PAssignmentExpressionNoName _assignmentExpressionNoName_;

    public AExpressionNoName()
    {
        // Constructor
    }

    public AExpressionNoName(
        @SuppressWarnings("hiding") PAssignmentExpressionNoName _assignmentExpressionNoName_)
    {
        // Constructor
        setAssignmentExpressionNoName(_assignmentExpressionNoName_);

    }

    @Override
    public Object clone()
    {
        return new AExpressionNoName(
            cloneNode(this._assignmentExpressionNoName_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpressionNoName(this);
    }

    public PAssignmentExpressionNoName getAssignmentExpressionNoName()
    {
        return this._assignmentExpressionNoName_;
    }

    public void setAssignmentExpressionNoName(PAssignmentExpressionNoName node)
    {
        if(this._assignmentExpressionNoName_ != null)
        {
            this._assignmentExpressionNoName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._assignmentExpressionNoName_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._assignmentExpressionNoName_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._assignmentExpressionNoName_ == child)
        {
            this._assignmentExpressionNoName_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._assignmentExpressionNoName_ == oldChild)
        {
            setAssignmentExpressionNoName((PAssignmentExpressionNoName) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}