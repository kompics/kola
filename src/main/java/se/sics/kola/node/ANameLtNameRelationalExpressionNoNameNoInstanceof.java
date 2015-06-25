/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ANameLtNameRelationalExpressionNoNameNoInstanceof extends PRelationalExpressionNoNameNoInstanceof
{
    private PName _name1_;
    private TLt _lt_;
    private PName _name2_;

    public ANameLtNameRelationalExpressionNoNameNoInstanceof()
    {
        // Constructor
    }

    public ANameLtNameRelationalExpressionNoNameNoInstanceof(
        @SuppressWarnings("hiding") PName _name1_,
        @SuppressWarnings("hiding") TLt _lt_,
        @SuppressWarnings("hiding") PName _name2_)
    {
        // Constructor
        setName1(_name1_);

        setLt(_lt_);

        setName2(_name2_);

    }

    @Override
    public Object clone()
    {
        return new ANameLtNameRelationalExpressionNoNameNoInstanceof(
            cloneNode(this._name1_),
            cloneNode(this._lt_),
            cloneNode(this._name2_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANameLtNameRelationalExpressionNoNameNoInstanceof(this);
    }

    public PName getName1()
    {
        return this._name1_;
    }

    public void setName1(PName node)
    {
        if(this._name1_ != null)
        {
            this._name1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._name1_ = node;
    }

    public TLt getLt()
    {
        return this._lt_;
    }

    public void setLt(TLt node)
    {
        if(this._lt_ != null)
        {
            this._lt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lt_ = node;
    }

    public PName getName2()
    {
        return this._name2_;
    }

    public void setName2(PName node)
    {
        if(this._name2_ != null)
        {
            this._name2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._name2_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._name1_)
            + toString(this._lt_)
            + toString(this._name2_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._name1_ == child)
        {
            this._name1_ = null;
            return;
        }

        if(this._lt_ == child)
        {
            this._lt_ = null;
            return;
        }

        if(this._name2_ == child)
        {
            this._name2_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._name1_ == oldChild)
        {
            setName1((PName) newChild);
            return;
        }

        if(this._lt_ == oldChild)
        {
            setLt((TLt) newChild);
            return;
        }

        if(this._name2_ == oldChild)
        {
            setName2((PName) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}