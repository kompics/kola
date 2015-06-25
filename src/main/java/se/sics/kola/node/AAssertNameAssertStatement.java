/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AAssertNameAssertStatement extends PAssertStatement
{
    private TAssertKeyword _assertKeyword_;
    private PName _name_;
    private TSemi _semi_;

    public AAssertNameAssertStatement()
    {
        // Constructor
    }

    public AAssertNameAssertStatement(
        @SuppressWarnings("hiding") TAssertKeyword _assertKeyword_,
        @SuppressWarnings("hiding") PName _name_,
        @SuppressWarnings("hiding") TSemi _semi_)
    {
        // Constructor
        setAssertKeyword(_assertKeyword_);

        setName(_name_);

        setSemi(_semi_);

    }

    @Override
    public Object clone()
    {
        return new AAssertNameAssertStatement(
            cloneNode(this._assertKeyword_),
            cloneNode(this._name_),
            cloneNode(this._semi_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAssertNameAssertStatement(this);
    }

    public TAssertKeyword getAssertKeyword()
    {
        return this._assertKeyword_;
    }

    public void setAssertKeyword(TAssertKeyword node)
    {
        if(this._assertKeyword_ != null)
        {
            this._assertKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._assertKeyword_ = node;
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

    public TSemi getSemi()
    {
        return this._semi_;
    }

    public void setSemi(TSemi node)
    {
        if(this._semi_ != null)
        {
            this._semi_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semi_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._assertKeyword_)
            + toString(this._name_)
            + toString(this._semi_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._assertKeyword_ == child)
        {
            this._assertKeyword_ = null;
            return;
        }

        if(this._name_ == child)
        {
            this._name_ = null;
            return;
        }

        if(this._semi_ == child)
        {
            this._semi_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._assertKeyword_ == oldChild)
        {
            setAssertKeyword((TAssertKeyword) newChild);
            return;
        }

        if(this._name_ == oldChild)
        {
            setName((PName) newChild);
            return;
        }

        if(this._semi_ == oldChild)
        {
            setSemi((TSemi) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}