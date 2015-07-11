/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ACatchClause extends PCatchClause
{
    private PCatchFormalParameter _catchFormalParameter_;
    private PBlock _block_;

    public ACatchClause()
    {
        // Constructor
    }

    public ACatchClause(
        @SuppressWarnings("hiding") PCatchFormalParameter _catchFormalParameter_,
        @SuppressWarnings("hiding") PBlock _block_)
    {
        // Constructor
        setCatchFormalParameter(_catchFormalParameter_);

        setBlock(_block_);

    }

    @Override
    public Object clone()
    {
        return new ACatchClause(
            cloneNode(this._catchFormalParameter_),
            cloneNode(this._block_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACatchClause(this);
    }

    public PCatchFormalParameter getCatchFormalParameter()
    {
        return this._catchFormalParameter_;
    }

    public void setCatchFormalParameter(PCatchFormalParameter node)
    {
        if(this._catchFormalParameter_ != null)
        {
            this._catchFormalParameter_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._catchFormalParameter_ = node;
    }

    public PBlock getBlock()
    {
        return this._block_;
    }

    public void setBlock(PBlock node)
    {
        if(this._block_ != null)
        {
            this._block_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._block_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._catchFormalParameter_)
            + toString(this._block_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._catchFormalParameter_ == child)
        {
            this._catchFormalParameter_ = null;
            return;
        }

        if(this._block_ == child)
        {
            this._block_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._catchFormalParameter_ == oldChild)
        {
            setCatchFormalParameter((PCatchFormalParameter) newChild);
            return;
        }

        if(this._block_ == oldChild)
        {
            setBlock((PBlock) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
