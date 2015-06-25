/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AFinallyTryStatement extends PTryStatement
{
    private TTryKeyword _tryKeyword_;
    private PBlock _block_;
    private PCatches _catches_;
    private PFinally _finally_;

    public AFinallyTryStatement()
    {
        // Constructor
    }

    public AFinallyTryStatement(
        @SuppressWarnings("hiding") TTryKeyword _tryKeyword_,
        @SuppressWarnings("hiding") PBlock _block_,
        @SuppressWarnings("hiding") PCatches _catches_,
        @SuppressWarnings("hiding") PFinally _finally_)
    {
        // Constructor
        setTryKeyword(_tryKeyword_);

        setBlock(_block_);

        setCatches(_catches_);

        setFinally(_finally_);

    }

    @Override
    public Object clone()
    {
        return new AFinallyTryStatement(
            cloneNode(this._tryKeyword_),
            cloneNode(this._block_),
            cloneNode(this._catches_),
            cloneNode(this._finally_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFinallyTryStatement(this);
    }

    public TTryKeyword getTryKeyword()
    {
        return this._tryKeyword_;
    }

    public void setTryKeyword(TTryKeyword node)
    {
        if(this._tryKeyword_ != null)
        {
            this._tryKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tryKeyword_ = node;
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

    public PCatches getCatches()
    {
        return this._catches_;
    }

    public void setCatches(PCatches node)
    {
        if(this._catches_ != null)
        {
            this._catches_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._catches_ = node;
    }

    public PFinally getFinally()
    {
        return this._finally_;
    }

    public void setFinally(PFinally node)
    {
        if(this._finally_ != null)
        {
            this._finally_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._finally_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tryKeyword_)
            + toString(this._block_)
            + toString(this._catches_)
            + toString(this._finally_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tryKeyword_ == child)
        {
            this._tryKeyword_ = null;
            return;
        }

        if(this._block_ == child)
        {
            this._block_ = null;
            return;
        }

        if(this._catches_ == child)
        {
            this._catches_ = null;
            return;
        }

        if(this._finally_ == child)
        {
            this._finally_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tryKeyword_ == oldChild)
        {
            setTryKeyword((TTryKeyword) newChild);
            return;
        }

        if(this._block_ == oldChild)
        {
            setBlock((PBlock) newChild);
            return;
        }

        if(this._catches_ == oldChild)
        {
            setCatches((PCatches) newChild);
            return;
        }

        if(this._finally_ == oldChild)
        {
            setFinally((PFinally) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}