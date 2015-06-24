/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AByteIntegralType extends PIntegralType
{
    private TByteKeyword _byteKeyword_;

    public AByteIntegralType()
    {
        // Constructor
    }

    public AByteIntegralType(
        @SuppressWarnings("hiding") TByteKeyword _byteKeyword_)
    {
        // Constructor
        setByteKeyword(_byteKeyword_);

    }

    @Override
    public Object clone()
    {
        return new AByteIntegralType(
            cloneNode(this._byteKeyword_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAByteIntegralType(this);
    }

    public TByteKeyword getByteKeyword()
    {
        return this._byteKeyword_;
    }

    public void setByteKeyword(TByteKeyword node)
    {
        if(this._byteKeyword_ != null)
        {
            this._byteKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._byteKeyword_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._byteKeyword_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._byteKeyword_ == child)
        {
            this._byteKeyword_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._byteKeyword_ == oldChild)
        {
            setByteKeyword((TByteKeyword) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
