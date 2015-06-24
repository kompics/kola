/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ATypeReferenceTypeList extends PReferenceTypeList
{
    private PReferenceType _referenceType_;

    public ATypeReferenceTypeList()
    {
        // Constructor
    }

    public ATypeReferenceTypeList(
        @SuppressWarnings("hiding") PReferenceType _referenceType_)
    {
        // Constructor
        setReferenceType(_referenceType_);

    }

    @Override
    public Object clone()
    {
        return new ATypeReferenceTypeList(
            cloneNode(this._referenceType_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATypeReferenceTypeList(this);
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._referenceType_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._referenceType_ == child)
        {
            this._referenceType_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._referenceType_ == oldChild)
        {
            setReferenceType((PReferenceType) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
