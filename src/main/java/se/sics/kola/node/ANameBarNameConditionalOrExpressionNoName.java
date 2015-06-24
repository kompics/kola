/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ANameBarNameConditionalOrExpressionNoName extends PConditionalOrExpressionNoName
{
    private PName _name1_;
    private TBarBar _barBar_;
    private PName _name2_;

    public ANameBarNameConditionalOrExpressionNoName()
    {
        // Constructor
    }

    public ANameBarNameConditionalOrExpressionNoName(
        @SuppressWarnings("hiding") PName _name1_,
        @SuppressWarnings("hiding") TBarBar _barBar_,
        @SuppressWarnings("hiding") PName _name2_)
    {
        // Constructor
        setName1(_name1_);

        setBarBar(_barBar_);

        setName2(_name2_);

    }

    @Override
    public Object clone()
    {
        return new ANameBarNameConditionalOrExpressionNoName(
            cloneNode(this._name1_),
            cloneNode(this._barBar_),
            cloneNode(this._name2_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANameBarNameConditionalOrExpressionNoName(this);
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

    public TBarBar getBarBar()
    {
        return this._barBar_;
    }

    public void setBarBar(TBarBar node)
    {
        if(this._barBar_ != null)
        {
            this._barBar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._barBar_ = node;
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
            + toString(this._barBar_)
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

        if(this._barBar_ == child)
        {
            this._barBar_ = null;
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

        if(this._barBar_ == oldChild)
        {
            setBarBar((TBarBar) newChild);
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
