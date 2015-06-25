/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AMinusNameAdditiveExpressionNoName extends PAdditiveExpressionNoName
{
    private PAdditiveExpressionNoName _additiveExpressionNoName_;
    private TMinus _minus_;
    private PName _name_;

    public AMinusNameAdditiveExpressionNoName()
    {
        // Constructor
    }

    public AMinusNameAdditiveExpressionNoName(
        @SuppressWarnings("hiding") PAdditiveExpressionNoName _additiveExpressionNoName_,
        @SuppressWarnings("hiding") TMinus _minus_,
        @SuppressWarnings("hiding") PName _name_)
    {
        // Constructor
        setAdditiveExpressionNoName(_additiveExpressionNoName_);

        setMinus(_minus_);

        setName(_name_);

    }

    @Override
    public Object clone()
    {
        return new AMinusNameAdditiveExpressionNoName(
            cloneNode(this._additiveExpressionNoName_),
            cloneNode(this._minus_),
            cloneNode(this._name_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMinusNameAdditiveExpressionNoName(this);
    }

    public PAdditiveExpressionNoName getAdditiveExpressionNoName()
    {
        return this._additiveExpressionNoName_;
    }

    public void setAdditiveExpressionNoName(PAdditiveExpressionNoName node)
    {
        if(this._additiveExpressionNoName_ != null)
        {
            this._additiveExpressionNoName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._additiveExpressionNoName_ = node;
    }

    public TMinus getMinus()
    {
        return this._minus_;
    }

    public void setMinus(TMinus node)
    {
        if(this._minus_ != null)
        {
            this._minus_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._minus_ = node;
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._additiveExpressionNoName_)
            + toString(this._minus_)
            + toString(this._name_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._additiveExpressionNoName_ == child)
        {
            this._additiveExpressionNoName_ = null;
            return;
        }

        if(this._minus_ == child)
        {
            this._minus_ = null;
            return;
        }

        if(this._name_ == child)
        {
            this._name_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._additiveExpressionNoName_ == oldChild)
        {
            setAdditiveExpressionNoName((PAdditiveExpressionNoName) newChild);
            return;
        }

        if(this._minus_ == oldChild)
        {
            setMinus((TMinus) newChild);
            return;
        }

        if(this._name_ == oldChild)
        {
            setName((PName) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}