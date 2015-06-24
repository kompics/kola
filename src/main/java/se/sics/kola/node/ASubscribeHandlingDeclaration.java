/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ASubscribeHandlingDeclaration extends PHandlingDeclaration
{
    private PSubscribeStatement _subscribeStatement_;

    public ASubscribeHandlingDeclaration()
    {
        // Constructor
    }

    public ASubscribeHandlingDeclaration(
        @SuppressWarnings("hiding") PSubscribeStatement _subscribeStatement_)
    {
        // Constructor
        setSubscribeStatement(_subscribeStatement_);

    }

    @Override
    public Object clone()
    {
        return new ASubscribeHandlingDeclaration(
            cloneNode(this._subscribeStatement_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASubscribeHandlingDeclaration(this);
    }

    public PSubscribeStatement getSubscribeStatement()
    {
        return this._subscribeStatement_;
    }

    public void setSubscribeStatement(PSubscribeStatement node)
    {
        if(this._subscribeStatement_ != null)
        {
            this._subscribeStatement_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._subscribeStatement_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._subscribeStatement_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._subscribeStatement_ == child)
        {
            this._subscribeStatement_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._subscribeStatement_ == oldChild)
        {
            setSubscribeStatement((PSubscribeStatement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
