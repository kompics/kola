/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ANameShrNameShiftExpressionNoName extends PShiftExpressionNoName
{
    private PName _name1_;
    private TShr _shr_;
    private PName _name2_;

    public ANameShrNameShiftExpressionNoName()
    {
        // Constructor
    }

    public ANameShrNameShiftExpressionNoName(
        @SuppressWarnings("hiding") PName _name1_,
        @SuppressWarnings("hiding") TShr _shr_,
        @SuppressWarnings("hiding") PName _name2_)
    {
        // Constructor
        setName1(_name1_);

        setShr(_shr_);

        setName2(_name2_);

    }

    @Override
    public Object clone()
    {
        return new ANameShrNameShiftExpressionNoName(
            cloneNode(this._name1_),
            cloneNode(this._shr_),
            cloneNode(this._name2_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANameShrNameShiftExpressionNoName(this);
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

    public TShr getShr()
    {
        return this._shr_;
    }

    public void setShr(TShr node)
    {
        if(this._shr_ != null)
        {
            this._shr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._shr_ = node;
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
            + toString(this._shr_)
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

        if(this._shr_ == child)
        {
            this._shr_ = null;
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

        if(this._shr_ == oldChild)
        {
            setShr((TShr) newChild);
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