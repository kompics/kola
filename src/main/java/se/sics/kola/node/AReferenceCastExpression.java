/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AReferenceCastExpression extends PCastExpression
{
    private TLPar _lPar_;
    private PReferenceType _referenceType_;
    private TRPar _rPar_;
    private PUnaryExpressionNotPlusMinusNoName _unaryExpressionNotPlusMinusNoName_;

    public AReferenceCastExpression()
    {
        // Constructor
    }

    public AReferenceCastExpression(
        @SuppressWarnings("hiding") TLPar _lPar_,
        @SuppressWarnings("hiding") PReferenceType _referenceType_,
        @SuppressWarnings("hiding") TRPar _rPar_,
        @SuppressWarnings("hiding") PUnaryExpressionNotPlusMinusNoName _unaryExpressionNotPlusMinusNoName_)
    {
        // Constructor
        setLPar(_lPar_);

        setReferenceType(_referenceType_);

        setRPar(_rPar_);

        setUnaryExpressionNotPlusMinusNoName(_unaryExpressionNotPlusMinusNoName_);

    }

    @Override
    public Object clone()
    {
        return new AReferenceCastExpression(
            cloneNode(this._lPar_),
            cloneNode(this._referenceType_),
            cloneNode(this._rPar_),
            cloneNode(this._unaryExpressionNotPlusMinusNoName_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAReferenceCastExpression(this);
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

    public PReferenceType getReferenceType()
    {
        return this._referenceType_;
    }

    public void setReferenceType(PReferenceType node)
    {
        if(this._referenceType_ != null)
        {
            this._referenceType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._referenceType_ = node;
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

    public PUnaryExpressionNotPlusMinusNoName getUnaryExpressionNotPlusMinusNoName()
    {
        return this._unaryExpressionNotPlusMinusNoName_;
    }

    public void setUnaryExpressionNotPlusMinusNoName(PUnaryExpressionNotPlusMinusNoName node)
    {
        if(this._unaryExpressionNotPlusMinusNoName_ != null)
        {
            this._unaryExpressionNotPlusMinusNoName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._unaryExpressionNotPlusMinusNoName_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._lPar_)
            + toString(this._referenceType_)
            + toString(this._rPar_)
            + toString(this._unaryExpressionNotPlusMinusNoName_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._lPar_ == child)
        {
            this._lPar_ = null;
            return;
        }

        if(this._referenceType_ == child)
        {
            this._referenceType_ = null;
            return;
        }

        if(this._rPar_ == child)
        {
            this._rPar_ = null;
            return;
        }

        if(this._unaryExpressionNotPlusMinusNoName_ == child)
        {
            this._unaryExpressionNotPlusMinusNoName_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(this._referenceType_ == oldChild)
        {
            setReferenceType((PReferenceType) newChild);
            return;
        }

        if(this._rPar_ == oldChild)
        {
            setRPar((TRPar) newChild);
            return;
        }

        if(this._unaryExpressionNotPlusMinusNoName_ == oldChild)
        {
            setUnaryExpressionNotPlusMinusNoName((PUnaryExpressionNotPlusMinusNoName) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}