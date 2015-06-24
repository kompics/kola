/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AIndicationsDeclaration extends PIndicationsDeclaration
{
    private TIndicationKeyword _indicationKeyword_;
    private TLBrc _lBrc_;
    private PIndicationDeclarations _indicationDeclarations_;
    private TRBrc _rBrc_;

    public AIndicationsDeclaration()
    {
        // Constructor
    }

    public AIndicationsDeclaration(
        @SuppressWarnings("hiding") TIndicationKeyword _indicationKeyword_,
        @SuppressWarnings("hiding") TLBrc _lBrc_,
        @SuppressWarnings("hiding") PIndicationDeclarations _indicationDeclarations_,
        @SuppressWarnings("hiding") TRBrc _rBrc_)
    {
        // Constructor
        setIndicationKeyword(_indicationKeyword_);

        setLBrc(_lBrc_);

        setIndicationDeclarations(_indicationDeclarations_);

        setRBrc(_rBrc_);

    }

    @Override
    public Object clone()
    {
        return new AIndicationsDeclaration(
            cloneNode(this._indicationKeyword_),
            cloneNode(this._lBrc_),
            cloneNode(this._indicationDeclarations_),
            cloneNode(this._rBrc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIndicationsDeclaration(this);
    }

    public TIndicationKeyword getIndicationKeyword()
    {
        return this._indicationKeyword_;
    }

    public void setIndicationKeyword(TIndicationKeyword node)
    {
        if(this._indicationKeyword_ != null)
        {
            this._indicationKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._indicationKeyword_ = node;
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

    public PIndicationDeclarations getIndicationDeclarations()
    {
        return this._indicationDeclarations_;
    }

    public void setIndicationDeclarations(PIndicationDeclarations node)
    {
        if(this._indicationDeclarations_ != null)
        {
            this._indicationDeclarations_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._indicationDeclarations_ = node;
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
            + toString(this._indicationKeyword_)
            + toString(this._lBrc_)
            + toString(this._indicationDeclarations_)
            + toString(this._rBrc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._indicationKeyword_ == child)
        {
            this._indicationKeyword_ = null;
            return;
        }

        if(this._lBrc_ == child)
        {
            this._lBrc_ = null;
            return;
        }

        if(this._indicationDeclarations_ == child)
        {
            this._indicationDeclarations_ = null;
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
        if(this._indicationKeyword_ == oldChild)
        {
            setIndicationKeyword((TIndicationKeyword) newChild);
            return;
        }

        if(this._lBrc_ == oldChild)
        {
            setLBrc((TLBrc) newChild);
            return;
        }

        if(this._indicationDeclarations_ == oldChild)
        {
            setIndicationDeclarations((PIndicationDeclarations) newChild);
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
