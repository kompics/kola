/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AArrayReferenceTypeNoArguments extends PReferenceTypeNoArguments
{
    private PArrayTypeNoArguments _arrayTypeNoArguments_;

    public AArrayReferenceTypeNoArguments()
    {
        // Constructor
    }

    public AArrayReferenceTypeNoArguments(
        @SuppressWarnings("hiding") PArrayTypeNoArguments _arrayTypeNoArguments_)
    {
        // Constructor
        setArrayTypeNoArguments(_arrayTypeNoArguments_);

    }

    @Override
    public Object clone()
    {
        return new AArrayReferenceTypeNoArguments(
            cloneNode(this._arrayTypeNoArguments_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArrayReferenceTypeNoArguments(this);
    }

    public PArrayTypeNoArguments getArrayTypeNoArguments()
    {
        return this._arrayTypeNoArguments_;
    }

    public void setArrayTypeNoArguments(PArrayTypeNoArguments node)
    {
        if(this._arrayTypeNoArguments_ != null)
        {
            this._arrayTypeNoArguments_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._arrayTypeNoArguments_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._arrayTypeNoArguments_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._arrayTypeNoArguments_ == child)
        {
            this._arrayTypeNoArguments_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._arrayTypeNoArguments_ == oldChild)
        {
            setArrayTypeNoArguments((PArrayTypeNoArguments) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
