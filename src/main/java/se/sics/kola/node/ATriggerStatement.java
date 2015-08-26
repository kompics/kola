/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ATriggerStatement extends PTriggerStatement
{
    private PExpression _event_;
    private PExpression _port_;

    public ATriggerStatement()
    {
        // Constructor
    }

    public ATriggerStatement(
        @SuppressWarnings("hiding") PExpression _event_,
        @SuppressWarnings("hiding") PExpression _port_)
    {
        // Constructor
        setEvent(_event_);

        setPort(_port_);

    }

    @Override
    public Object clone()
    {
        return new ATriggerStatement(
            cloneNode(this._event_),
            cloneNode(this._port_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATriggerStatement(this);
    }

    public PExpression getEvent()
    {
        return this._event_;
    }

    public void setEvent(PExpression node)
    {
        if(this._event_ != null)
        {
            this._event_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._event_ = node;
    }

    public PExpression getPort()
    {
        return this._port_;
    }

    public void setPort(PExpression node)
    {
        if(this._port_ != null)
        {
            this._port_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._port_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._event_)
            + toString(this._port_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._event_ == child)
        {
            this._event_ = null;
            return;
        }

        if(this._port_ == child)
        {
            this._port_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._event_ == oldChild)
        {
            setEvent((PExpression) newChild);
            return;
        }

        if(this._port_ == oldChild)
        {
            setPort((PExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
