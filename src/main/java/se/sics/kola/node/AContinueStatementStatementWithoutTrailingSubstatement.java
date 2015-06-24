/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AContinueStatementStatementWithoutTrailingSubstatement extends PStatementWithoutTrailingSubstatement
{
    private PContinueStatement _continueStatement_;

    public AContinueStatementStatementWithoutTrailingSubstatement()
    {
        // Constructor
    }

    public AContinueStatementStatementWithoutTrailingSubstatement(
        @SuppressWarnings("hiding") PContinueStatement _continueStatement_)
    {
        // Constructor
        setContinueStatement(_continueStatement_);

    }

    @Override
    public Object clone()
    {
        return new AContinueStatementStatementWithoutTrailingSubstatement(
            cloneNode(this._continueStatement_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAContinueStatementStatementWithoutTrailingSubstatement(this);
    }

    public PContinueStatement getContinueStatement()
    {
        return this._continueStatement_;
    }

    public void setContinueStatement(PContinueStatement node)
    {
        if(this._continueStatement_ != null)
        {
            this._continueStatement_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._continueStatement_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._continueStatement_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._continueStatement_ == child)
        {
            this._continueStatement_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._continueStatement_ == oldChild)
        {
            setContinueStatement((PContinueStatement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
