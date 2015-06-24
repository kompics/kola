/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ASwitchBlock extends PSwitchBlock
{
    private TLBrc _lBrc_;
    private PSwitchBlockStatementGroups _switchBlockStatementGroups_;
    private PSwitchLabels _switchLabels_;
    private TRBrc _rBrc_;

    public ASwitchBlock()
    {
        // Constructor
    }

    public ASwitchBlock(
        @SuppressWarnings("hiding") TLBrc _lBrc_,
        @SuppressWarnings("hiding") PSwitchBlockStatementGroups _switchBlockStatementGroups_,
        @SuppressWarnings("hiding") PSwitchLabels _switchLabels_,
        @SuppressWarnings("hiding") TRBrc _rBrc_)
    {
        // Constructor
        setLBrc(_lBrc_);

        setSwitchBlockStatementGroups(_switchBlockStatementGroups_);

        setSwitchLabels(_switchLabels_);

        setRBrc(_rBrc_);

    }

    @Override
    public Object clone()
    {
        return new ASwitchBlock(
            cloneNode(this._lBrc_),
            cloneNode(this._switchBlockStatementGroups_),
            cloneNode(this._switchLabels_),
            cloneNode(this._rBrc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASwitchBlock(this);
    }

    public TLBrc getLBrc()
    {
        return this._lBrc_;
    }

    public void setLBrc(TLBrc node)
    {
        if(this._lBrc_ != null)
        {
            this._lBrc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lBrc_ = node;
    }

    public PSwitchBlockStatementGroups getSwitchBlockStatementGroups()
    {
        return this._switchBlockStatementGroups_;
    }

    public void setSwitchBlockStatementGroups(PSwitchBlockStatementGroups node)
    {
        if(this._switchBlockStatementGroups_ != null)
        {
            this._switchBlockStatementGroups_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._switchBlockStatementGroups_ = node;
    }

    public PSwitchLabels getSwitchLabels()
    {
        return this._switchLabels_;
    }

    public void setSwitchLabels(PSwitchLabels node)
    {
        if(this._switchLabels_ != null)
        {
            this._switchLabels_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._switchLabels_ = node;
    }

    public TRBrc getRBrc()
    {
        return this._rBrc_;
    }

    public void setRBrc(TRBrc node)
    {
        if(this._rBrc_ != null)
        {
            this._rBrc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rBrc_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._lBrc_)
            + toString(this._switchBlockStatementGroups_)
            + toString(this._switchLabels_)
            + toString(this._rBrc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._lBrc_ == child)
        {
            this._lBrc_ = null;
            return;
        }

        if(this._switchBlockStatementGroups_ == child)
        {
            this._switchBlockStatementGroups_ = null;
            return;
        }

        if(this._switchLabels_ == child)
        {
            this._switchLabels_ = null;
            return;
        }

        if(this._rBrc_ == child)
        {
            this._rBrc_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._lBrc_ == oldChild)
        {
            setLBrc((TLBrc) newChild);
            return;
        }

        if(this._switchBlockStatementGroups_ == oldChild)
        {
            setSwitchBlockStatementGroups((PSwitchBlockStatementGroups) newChild);
            return;
        }

        if(this._switchLabels_ == oldChild)
        {
            setSwitchLabels((PSwitchLabels) newChild);
            return;
        }

        if(this._rBrc_ == oldChild)
        {
            setRBrc((TRBrc) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
