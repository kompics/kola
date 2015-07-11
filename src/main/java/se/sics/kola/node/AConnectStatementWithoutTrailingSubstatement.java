/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AConnectStatementWithoutTrailingSubstatement extends PStatementWithoutTrailingSubstatement
{
    private PConnectStatement _connectStatement_;

    public AConnectStatementWithoutTrailingSubstatement()
    {
        // Constructor
    }

    public AConnectStatementWithoutTrailingSubstatement(
        @SuppressWarnings("hiding") PConnectStatement _connectStatement_)
    {
        // Constructor
        setConnectStatement(_connectStatement_);

    }

    @Override
    public Object clone()
    {
        return new AConnectStatementWithoutTrailingSubstatement(
            cloneNode(this._connectStatement_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAConnectStatementWithoutTrailingSubstatement(this);
    }

    public PConnectStatement getConnectStatement()
    {
        return this._connectStatement_;
    }

    public void setConnectStatement(PConnectStatement node)
    {
        if(this._connectStatement_ != null)
        {
            this._connectStatement_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._connectStatement_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._connectStatement_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._connectStatement_ == child)
        {
            this._connectStatement_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._connectStatement_ == oldChild)
        {
            setConnectStatement((PConnectStatement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
