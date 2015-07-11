/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AExpressionBasicForStatement extends PBasicForStatement
{
    private PForInit _init_;
    private PExpressionNoName _cond_;
    private PForUpdate _update_;
    private PStatement _do_;

    public AExpressionBasicForStatement()
    {
        // Constructor
    }

    public AExpressionBasicForStatement(
        @SuppressWarnings("hiding") PForInit _init_,
        @SuppressWarnings("hiding") PExpressionNoName _cond_,
        @SuppressWarnings("hiding") PForUpdate _update_,
        @SuppressWarnings("hiding") PStatement _do_)
    {
        // Constructor
        setInit(_init_);

        setCond(_cond_);

        setUpdate(_update_);

        setDo(_do_);

    }

    @Override
    public Object clone()
    {
        return new AExpressionBasicForStatement(
            cloneNode(this._init_),
            cloneNode(this._cond_),
            cloneNode(this._update_),
            cloneNode(this._do_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpressionBasicForStatement(this);
    }

    public PForInit getInit()
    {
        return this._init_;
    }

    public void setInit(PForInit node)
    {
        if(this._init_ != null)
        {
            this._init_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._init_ = node;
    }

    public PExpressionNoName getCond()
    {
        return this._cond_;
    }

    public void setCond(PExpressionNoName node)
    {
        if(this._cond_ != null)
        {
            this._cond_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._cond_ = node;
    }

    public PForUpdate getUpdate()
    {
        return this._update_;
    }

    public void setUpdate(PForUpdate node)
    {
        if(this._update_ != null)
        {
            this._update_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._update_ = node;
    }

    public PStatement getDo()
    {
        return this._do_;
    }

    public void setDo(PStatement node)
    {
        if(this._do_ != null)
        {
            this._do_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._do_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._init_)
            + toString(this._cond_)
            + toString(this._update_)
            + toString(this._do_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._init_ == child)
        {
            this._init_ = null;
            return;
        }

        if(this._cond_ == child)
        {
            this._cond_ = null;
            return;
        }

        if(this._update_ == child)
        {
            this._update_ = null;
            return;
        }

        if(this._do_ == child)
        {
            this._do_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._init_ == oldChild)
        {
            setInit((PForInit) newChild);
            return;
        }

        if(this._cond_ == oldChild)
        {
            setCond((PExpressionNoName) newChild);
            return;
        }

        if(this._update_ == oldChild)
        {
            setUpdate((PForUpdate) newChild);
            return;
        }

        if(this._do_ == oldChild)
        {
            setDo((PStatement) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
