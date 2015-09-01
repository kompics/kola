/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AKolaExpressionNoName extends PExpressionNoName
{
    private PName _name_;
    private PKolaKeyword _kolaKeyword_;

    public AKolaExpressionNoName()
    {
        // Constructor
    }

    public AKolaExpressionNoName(
        @SuppressWarnings("hiding") PName _name_,
        @SuppressWarnings("hiding") PKolaKeyword _kolaKeyword_)
    {
        // Constructor
        setName(_name_);

        setKolaKeyword(_kolaKeyword_);

    }

    @Override
    public Object clone()
    {
        return new AKolaExpressionNoName(
            cloneNode(this._name_),
            cloneNode(this._kolaKeyword_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAKolaExpressionNoName(this);
    }

    public PName getName()
    {
        return this._name_;
    }

    public void setName(PName node)
    {
        if(this._name_ != null)
        {
            this._name_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._name_ = node;
    }

    public PKolaKeyword getKolaKeyword()
    {
        return this._kolaKeyword_;
    }

    public void setKolaKeyword(PKolaKeyword node)
    {
        if(this._kolaKeyword_ != null)
        {
            this._kolaKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._kolaKeyword_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._name_)
            + toString(this._kolaKeyword_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._name_ == child)
        {
            this._name_ = null;
            return;
        }

        if(this._kolaKeyword_ == child)
        {
            this._kolaKeyword_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._name_ == oldChild)
        {
            setName((PName) newChild);
            return;
        }

        if(this._kolaKeyword_ == oldChild)
        {
            setKolaKeyword((PKolaKeyword) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
