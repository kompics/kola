/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AGroupsSwitchBlockStatementGroups extends PSwitchBlockStatementGroups
{
    private PSwitchBlockStatementGroups _switchBlockStatementGroups_;
    private PSwitchBlockStatementGroup _switchBlockStatementGroup_;

    public AGroupsSwitchBlockStatementGroups()
    {
        // Constructor
    }

    public AGroupsSwitchBlockStatementGroups(
        @SuppressWarnings("hiding") PSwitchBlockStatementGroups _switchBlockStatementGroups_,
        @SuppressWarnings("hiding") PSwitchBlockStatementGroup _switchBlockStatementGroup_)
    {
        // Constructor
        setSwitchBlockStatementGroups(_switchBlockStatementGroups_);

        setSwitchBlockStatementGroup(_switchBlockStatementGroup_);

    }

    @Override
    public Object clone()
    {
        return new AGroupsSwitchBlockStatementGroups(
            cloneNode(this._switchBlockStatementGroups_),
            cloneNode(this._switchBlockStatementGroup_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAGroupsSwitchBlockStatementGroups(this);
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

    public PSwitchBlockStatementGroup getSwitchBlockStatementGroup()
    {
        return this._switchBlockStatementGroup_;
    }

    public void setSwitchBlockStatementGroup(PSwitchBlockStatementGroup node)
    {
        if(this._switchBlockStatementGroup_ != null)
        {
            this._switchBlockStatementGroup_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._switchBlockStatementGroup_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._switchBlockStatementGroups_)
            + toString(this._switchBlockStatementGroup_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._switchBlockStatementGroups_ == child)
        {
            this._switchBlockStatementGroups_ = null;
            return;
        }

        if(this._switchBlockStatementGroup_ == child)
        {
            this._switchBlockStatementGroup_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._switchBlockStatementGroups_ == oldChild)
        {
            setSwitchBlockStatementGroups((PSwitchBlockStatementGroups) newChild);
            return;
        }

        if(this._switchBlockStatementGroup_ == oldChild)
        {
            setSwitchBlockStatementGroup((PSwitchBlockStatementGroup) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}