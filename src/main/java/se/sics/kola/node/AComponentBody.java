/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AComponentBody extends PComponentBody
{
    private TLBrc _lBrc_;
    private PComponentBodyDeclarations _componentBodyDeclarations_;
    private TRBrc _rBrc_;

    public AComponentBody()
    {
        // Constructor
    }

    public AComponentBody(
        @SuppressWarnings("hiding") TLBrc _lBrc_,
        @SuppressWarnings("hiding") PComponentBodyDeclarations _componentBodyDeclarations_,
        @SuppressWarnings("hiding") TRBrc _rBrc_)
    {
        // Constructor
        setLBrc(_lBrc_);

        setComponentBodyDeclarations(_componentBodyDeclarations_);

        setRBrc(_rBrc_);

    }

    @Override
    public Object clone()
    {
        return new AComponentBody(
            cloneNode(this._lBrc_),
            cloneNode(this._componentBodyDeclarations_),
            cloneNode(this._rBrc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAComponentBody(this);
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

    public PComponentBodyDeclarations getComponentBodyDeclarations()
    {
        return this._componentBodyDeclarations_;
    }

    public void setComponentBodyDeclarations(PComponentBodyDeclarations node)
    {
        if(this._componentBodyDeclarations_ != null)
        {
            this._componentBodyDeclarations_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._componentBodyDeclarations_ = node;
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
            + toString(this._componentBodyDeclarations_)
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

        if(this._componentBodyDeclarations_ == child)
        {
            this._componentBodyDeclarations_ = null;
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

        if(this._componentBodyDeclarations_ == oldChild)
        {
            setComponentBodyDeclarations((PComponentBodyDeclarations) newChild);
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