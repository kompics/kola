/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AArrayElementValue extends PElementValue
{
    private PElementValueArrayInitializer _elementValueArrayInitializer_;

    public AArrayElementValue()
    {
        // Constructor
    }

    public AArrayElementValue(
        @SuppressWarnings("hiding") PElementValueArrayInitializer _elementValueArrayInitializer_)
    {
        // Constructor
        setElementValueArrayInitializer(_elementValueArrayInitializer_);

    }

    @Override
    public Object clone()
    {
        return new AArrayElementValue(
            cloneNode(this._elementValueArrayInitializer_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArrayElementValue(this);
    }

    public PElementValueArrayInitializer getElementValueArrayInitializer()
    {
        return this._elementValueArrayInitializer_;
    }

    public void setElementValueArrayInitializer(PElementValueArrayInitializer node)
    {
        if(this._elementValueArrayInitializer_ != null)
        {
            this._elementValueArrayInitializer_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._elementValueArrayInitializer_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._elementValueArrayInitializer_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._elementValueArrayInitializer_ == child)
        {
            this._elementValueArrayInitializer_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._elementValueArrayInitializer_ == oldChild)
        {
            setElementValueArrayInitializer((PElementValueArrayInitializer) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
