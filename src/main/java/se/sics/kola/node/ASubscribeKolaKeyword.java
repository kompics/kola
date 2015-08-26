/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ASubscribeKolaKeyword extends PKolaKeyword
{
    private TSubscribeKeyword _subscribeKeyword_;

    public ASubscribeKolaKeyword()
    {
        // Constructor
    }

    public ASubscribeKolaKeyword(
        @SuppressWarnings("hiding") TSubscribeKeyword _subscribeKeyword_)
    {
        // Constructor
        setSubscribeKeyword(_subscribeKeyword_);

    }

    @Override
    public Object clone()
    {
        return new ASubscribeKolaKeyword(
            cloneNode(this._subscribeKeyword_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASubscribeKolaKeyword(this);
    }

    public TSubscribeKeyword getSubscribeKeyword()
    {
        return this._subscribeKeyword_;
    }

    public void setSubscribeKeyword(TSubscribeKeyword node)
    {
        if(this._subscribeKeyword_ != null)
        {
            this._subscribeKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._subscribeKeyword_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._subscribeKeyword_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._subscribeKeyword_ == child)
        {
            this._subscribeKeyword_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._subscribeKeyword_ == oldChild)
        {
            setSubscribeKeyword((TSubscribeKeyword) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
