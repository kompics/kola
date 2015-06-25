/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AConstructorDeclarator extends PConstructorDeclarator
{
    private PTypeParameters _typeParameters_;
    private PSimpleTypeName _simpleTypeName_;
    private TLPar _lPar_;
    private PFormalParameterList _formalParameterList_;
    private TRPar _rPar_;

    public AConstructorDeclarator()
    {
        // Constructor
    }

    public AConstructorDeclarator(
        @SuppressWarnings("hiding") PTypeParameters _typeParameters_,
        @SuppressWarnings("hiding") PSimpleTypeName _simpleTypeName_,
        @SuppressWarnings("hiding") TLPar _lPar_,
        @SuppressWarnings("hiding") PFormalParameterList _formalParameterList_,
        @SuppressWarnings("hiding") TRPar _rPar_)
    {
        // Constructor
        setTypeParameters(_typeParameters_);

        setSimpleTypeName(_simpleTypeName_);

        setLPar(_lPar_);

        setFormalParameterList(_formalParameterList_);

        setRPar(_rPar_);

    }

    @Override
    public Object clone()
    {
        return new AConstructorDeclarator(
            cloneNode(this._typeParameters_),
            cloneNode(this._simpleTypeName_),
            cloneNode(this._lPar_),
            cloneNode(this._formalParameterList_),
            cloneNode(this._rPar_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAConstructorDeclarator(this);
    }

    public PTypeParameters getTypeParameters()
    {
        return this._typeParameters_;
    }

    public void setTypeParameters(PTypeParameters node)
    {
        if(this._typeParameters_ != null)
        {
            this._typeParameters_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._typeParameters_ = node;
    }

    public PSimpleTypeName getSimpleTypeName()
    {
        return this._simpleTypeName_;
    }

    public void setSimpleTypeName(PSimpleTypeName node)
    {
        if(this._simpleTypeName_ != null)
        {
            this._simpleTypeName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._simpleTypeName_ = node;
    }

    public TLPar getLPar()
    {
        return this._lPar_;
    }

    public void setLPar(TLPar node)
    {
        if(this._lPar_ != null)
        {
            this._lPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lPar_ = node;
    }

    public PFormalParameterList getFormalParameterList()
    {
        return this._formalParameterList_;
    }

    public void setFormalParameterList(PFormalParameterList node)
    {
        if(this._formalParameterList_ != null)
        {
            this._formalParameterList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._formalParameterList_ = node;
    }

    public TRPar getRPar()
    {
        return this._rPar_;
    }

    public void setRPar(TRPar node)
    {
        if(this._rPar_ != null)
        {
            this._rPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rPar_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._typeParameters_)
            + toString(this._simpleTypeName_)
            + toString(this._lPar_)
            + toString(this._formalParameterList_)
            + toString(this._rPar_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._typeParameters_ == child)
        {
            this._typeParameters_ = null;
            return;
        }

        if(this._simpleTypeName_ == child)
        {
            this._simpleTypeName_ = null;
            return;
        }

        if(this._lPar_ == child)
        {
            this._lPar_ = null;
            return;
        }

        if(this._formalParameterList_ == child)
        {
            this._formalParameterList_ = null;
            return;
        }

        if(this._rPar_ == child)
        {
            this._rPar_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._typeParameters_ == oldChild)
        {
            setTypeParameters((PTypeParameters) newChild);
            return;
        }

        if(this._simpleTypeName_ == oldChild)
        {
            setSimpleTypeName((PSimpleTypeName) newChild);
            return;
        }

        if(this._lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(this._formalParameterList_ == oldChild)
        {
            setFormalParameterList((PFormalParameterList) newChild);
            return;
        }

        if(this._rPar_ == oldChild)
        {
            setRPar((TRPar) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}