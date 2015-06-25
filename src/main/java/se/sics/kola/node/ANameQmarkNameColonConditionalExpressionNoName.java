/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ANameQmarkNameColonConditionalExpressionNoName extends PConditionalExpressionNoName
{
    private PName _name1_;
    private TQmark _qmark_;
    private PName _name2_;
    private TColon _colon_;
    private PConditionalExpressionNoName _conditionalExpressionNoName_;

    public ANameQmarkNameColonConditionalExpressionNoName()
    {
        // Constructor
    }

    public ANameQmarkNameColonConditionalExpressionNoName(
        @SuppressWarnings("hiding") PName _name1_,
        @SuppressWarnings("hiding") TQmark _qmark_,
        @SuppressWarnings("hiding") PName _name2_,
        @SuppressWarnings("hiding") TColon _colon_,
        @SuppressWarnings("hiding") PConditionalExpressionNoName _conditionalExpressionNoName_)
    {
        // Constructor
        setName1(_name1_);

        setQmark(_qmark_);

        setName2(_name2_);

        setColon(_colon_);

        setConditionalExpressionNoName(_conditionalExpressionNoName_);

    }

    @Override
    public Object clone()
    {
        return new ANameQmarkNameColonConditionalExpressionNoName(
            cloneNode(this._name1_),
            cloneNode(this._qmark_),
            cloneNode(this._name2_),
            cloneNode(this._colon_),
            cloneNode(this._conditionalExpressionNoName_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANameQmarkNameColonConditionalExpressionNoName(this);
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

    public TQmark getQmark()
    {
        return this._qmark_;
    }

    public void setQmark(TQmark node)
    {
        if(this._qmark_ != null)
        {
            this._qmark_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._qmark_ = node;
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

    public TColon getColon()
    {
        return this._colon_;
    }

    public void setColon(TColon node)
    {
        if(this._colon_ != null)
        {
            this._colon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._colon_ = node;
    }

    public PConditionalExpressionNoName getConditionalExpressionNoName()
    {
        return this._conditionalExpressionNoName_;
    }

    public void setConditionalExpressionNoName(PConditionalExpressionNoName node)
    {
        if(this._conditionalExpressionNoName_ != null)
        {
            this._conditionalExpressionNoName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._conditionalExpressionNoName_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._name1_)
            + toString(this._qmark_)
            + toString(this._name2_)
            + toString(this._colon_)
            + toString(this._conditionalExpressionNoName_);
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

        if(this._qmark_ == child)
        {
            this._qmark_ = null;
            return;
        }

        if(this._name2_ == child)
        {
            this._name2_ = null;
            return;
        }

        if(this._colon_ == child)
        {
            this._colon_ = null;
            return;
        }

        if(this._conditionalExpressionNoName_ == child)
        {
            this._conditionalExpressionNoName_ = null;
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

        if(this._qmark_ == oldChild)
        {
            setQmark((TQmark) newChild);
            return;
        }

        if(this._name2_ == oldChild)
        {
            setName2((PName) newChild);
            return;
        }

        if(this._colon_ == oldChild)
        {
            setColon((TColon) newChild);
            return;
        }

        if(this._conditionalExpressionNoName_ == oldChild)
        {
            setConditionalExpressionNoName((PConditionalExpressionNoName) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}