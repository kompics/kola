/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AConstructorBody extends PConstructorBody
{
    private TLBrc _lBrc_;
    private PExplicitConstructorInvocation _explicitConstructorInvocation_;
    private PBlockStatements _blockStatements_;
    private TRBrc _rBrc_;

    public AConstructorBody()
    {
        // Constructor
    }

    public AConstructorBody(
        @SuppressWarnings("hiding") TLBrc _lBrc_,
        @SuppressWarnings("hiding") PExplicitConstructorInvocation _explicitConstructorInvocation_,
        @SuppressWarnings("hiding") PBlockStatements _blockStatements_,
        @SuppressWarnings("hiding") TRBrc _rBrc_)
    {
        // Constructor
        setLBrc(_lBrc_);

        setExplicitConstructorInvocation(_explicitConstructorInvocation_);

        setBlockStatements(_blockStatements_);

        setRBrc(_rBrc_);

    }

    @Override
    public Object clone()
    {
        return new AConstructorBody(
            cloneNode(this._lBrc_),
            cloneNode(this._explicitConstructorInvocation_),
            cloneNode(this._blockStatements_),
            cloneNode(this._rBrc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAConstructorBody(this);
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

    public PExplicitConstructorInvocation getExplicitConstructorInvocation()
    {
        return this._explicitConstructorInvocation_;
    }

    public void setExplicitConstructorInvocation(PExplicitConstructorInvocation node)
    {
        if(this._explicitConstructorInvocation_ != null)
        {
            this._explicitConstructorInvocation_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._explicitConstructorInvocation_ = node;
    }

    public PBlockStatements getBlockStatements()
    {
        return this._blockStatements_;
    }

    public void setBlockStatements(PBlockStatements node)
    {
        if(this._blockStatements_ != null)
        {
            this._blockStatements_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._blockStatements_ = node;
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
            + toString(this._explicitConstructorInvocation_)
            + toString(this._blockStatements_)
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

        if(this._explicitConstructorInvocation_ == child)
        {
            this._explicitConstructorInvocation_ = null;
            return;
        }

        if(this._blockStatements_ == child)
        {
            this._blockStatements_ = null;
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

        if(this._explicitConstructorInvocation_ == oldChild)
        {
            setExplicitConstructorInvocation((PExplicitConstructorInvocation) newChild);
            return;
        }

        if(this._blockStatements_ == oldChild)
        {
            setBlockStatements((PBlockStatements) newChild);
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
