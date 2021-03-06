/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AReferenceTypeNoArguments extends PTypeNoArguments
{
    private PReferenceTypeNoArguments _referenceTypeNoArguments_;

    public AReferenceTypeNoArguments()
    {
        // Constructor
    }

    public AReferenceTypeNoArguments(
        @SuppressWarnings("hiding") PReferenceTypeNoArguments _referenceTypeNoArguments_)
    {
        // Constructor
        setReferenceTypeNoArguments(_referenceTypeNoArguments_);

    }

    @Override
    public Object clone()
    {
        return new AReferenceTypeNoArguments(
            cloneNode(this._referenceTypeNoArguments_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAReferenceTypeNoArguments(this);
    }

    public PReferenceTypeNoArguments getReferenceTypeNoArguments()
    {
        return this._referenceTypeNoArguments_;
    }

    public void setReferenceTypeNoArguments(PReferenceTypeNoArguments node)
    {
        if(this._referenceTypeNoArguments_ != null)
        {
            this._referenceTypeNoArguments_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._referenceTypeNoArguments_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._referenceTypeNoArguments_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._referenceTypeNoArguments_ == child)
        {
            this._referenceTypeNoArguments_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._referenceTypeNoArguments_ == oldChild)
        {
            setReferenceTypeNoArguments((PReferenceTypeNoArguments) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
