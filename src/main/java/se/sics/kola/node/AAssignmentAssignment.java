/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AAssignmentAssignment extends PAssignment
{
    private PLeftHandSide _leftHandSide_;
    private PAssignmentOperator _assignmentOperator_;
    private PAssignmentExpressionNoName _assignmentExpressionNoName_;

    public AAssignmentAssignment()
    {
        // Constructor
    }

    public AAssignmentAssignment(
        @SuppressWarnings("hiding") PLeftHandSide _leftHandSide_,
        @SuppressWarnings("hiding") PAssignmentOperator _assignmentOperator_,
        @SuppressWarnings("hiding") PAssignmentExpressionNoName _assignmentExpressionNoName_)
    {
        // Constructor
        setLeftHandSide(_leftHandSide_);

        setAssignmentOperator(_assignmentOperator_);

        setAssignmentExpressionNoName(_assignmentExpressionNoName_);

    }

    @Override
    public Object clone()
    {
        return new AAssignmentAssignment(
            cloneNode(this._leftHandSide_),
            cloneNode(this._assignmentOperator_),
            cloneNode(this._assignmentExpressionNoName_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAssignmentAssignment(this);
    }

    public PLeftHandSide getLeftHandSide()
    {
        return this._leftHandSide_;
    }

    public void setLeftHandSide(PLeftHandSide node)
    {
        if(this._leftHandSide_ != null)
        {
            this._leftHandSide_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._leftHandSide_ = node;
    }

    public PAssignmentOperator getAssignmentOperator()
    {
        return this._assignmentOperator_;
    }

    public void setAssignmentOperator(PAssignmentOperator node)
    {
        if(this._assignmentOperator_ != null)
        {
            this._assignmentOperator_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._assignmentOperator_ = node;
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
            + toString(this._leftHandSide_)
            + toString(this._assignmentOperator_)
            + toString(this._assignmentExpressionNoName_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._leftHandSide_ == child)
        {
            this._leftHandSide_ = null;
            return;
        }

        if(this._assignmentOperator_ == child)
        {
            this._assignmentOperator_ = null;
            return;
        }

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
        if(this._leftHandSide_ == oldChild)
        {
            setLeftHandSide((PLeftHandSide) newChild);
            return;
        }

        if(this._assignmentOperator_ == oldChild)
        {
            setAssignmentOperator((PAssignmentOperator) newChild);
            return;
        }

        if(this._assignmentExpressionNoName_ == oldChild)
        {
            setAssignmentExpressionNoName((PAssignmentExpressionNoName) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
