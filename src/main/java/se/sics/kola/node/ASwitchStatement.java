/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ASwitchStatement extends PSwitchStatement
{
    private PExpression _target_;
    private PSwitchBlock _switchBlock_;

    public ASwitchStatement()
    {
        // Constructor
    }

    public ASwitchStatement(
        @SuppressWarnings("hiding") PExpression _target_,
        @SuppressWarnings("hiding") PSwitchBlock _switchBlock_)
    {
        // Constructor
        setTarget(_target_);

        setSwitchBlock(_switchBlock_);

    }

    @Override
    public Object clone()
    {
        return new ASwitchStatement(
            cloneNode(this._target_),
            cloneNode(this._switchBlock_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASwitchStatement(this);
    }

    public PExpression getTarget()
    {
        return this._target_;
    }

    public void setTarget(PExpression node)
    {
        if(this._target_ != null)
        {
            this._target_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._target_ = node;
    }

    public PSwitchBlock getSwitchBlock()
    {
        return this._switchBlock_;
    }

    public void setSwitchBlock(PSwitchBlock node)
    {
        if(this._switchBlock_ != null)
        {
            this._switchBlock_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._switchBlock_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._target_)
            + toString(this._switchBlock_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._target_ == child)
        {
            this._target_ = null;
            return;
        }

        if(this._switchBlock_ == child)
        {
            this._switchBlock_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._target_ == oldChild)
        {
            setTarget((PExpression) newChild);
            return;
        }

        if(this._switchBlock_ == oldChild)
        {
            setSwitchBlock((PSwitchBlock) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}