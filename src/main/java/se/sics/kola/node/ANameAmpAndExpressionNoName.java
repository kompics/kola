/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ANameAmpAndExpressionNoName extends PAndExpressionNoName
{
    private PName _name_;
    private TAmp _amp_;
    private PEqualityExpressionNoName _equalityExpressionNoName_;

    public ANameAmpAndExpressionNoName()
    {
        // Constructor
    }

    public ANameAmpAndExpressionNoName(
        @SuppressWarnings("hiding") PName _name_,
        @SuppressWarnings("hiding") TAmp _amp_,
        @SuppressWarnings("hiding") PEqualityExpressionNoName _equalityExpressionNoName_)
    {
        // Constructor
        setName(_name_);

        setAmp(_amp_);

        setEqualityExpressionNoName(_equalityExpressionNoName_);

    }

    @Override
    public Object clone()
    {
        return new ANameAmpAndExpressionNoName(
            cloneNode(this._name_),
            cloneNode(this._amp_),
            cloneNode(this._equalityExpressionNoName_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANameAmpAndExpressionNoName(this);
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

    public TAmp getAmp()
    {
        return this._amp_;
    }

    public void setAmp(TAmp node)
    {
        if(this._amp_ != null)
        {
            this._amp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._amp_ = node;
    }

    public PEqualityExpressionNoName getEqualityExpressionNoName()
    {
        return this._equalityExpressionNoName_;
    }

    public void setEqualityExpressionNoName(PEqualityExpressionNoName node)
    {
        if(this._equalityExpressionNoName_ != null)
        {
            this._equalityExpressionNoName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._equalityExpressionNoName_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._name_)
            + toString(this._amp_)
            + toString(this._equalityExpressionNoName_);
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

        if(this._amp_ == child)
        {
            this._amp_ = null;
            return;
        }

        if(this._equalityExpressionNoName_ == child)
        {
            this._equalityExpressionNoName_ = null;
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

        if(this._amp_ == oldChild)
        {
            setAmp((TAmp) newChild);
            return;
        }

        if(this._equalityExpressionNoName_ == oldChild)
        {
            setEqualityExpressionNoName((PEqualityExpressionNoName) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}