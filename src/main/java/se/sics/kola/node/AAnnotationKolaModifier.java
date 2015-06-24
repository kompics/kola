/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AAnnotationKolaModifier extends PKolaModifier
{
    private PAnnotation _annotation_;

    public AAnnotationKolaModifier()
    {
        // Constructor
    }

    public AAnnotationKolaModifier(
        @SuppressWarnings("hiding") PAnnotation _annotation_)
    {
        // Constructor
        setAnnotation(_annotation_);

    }

    @Override
    public Object clone()
    {
        return new AAnnotationKolaModifier(
            cloneNode(this._annotation_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAnnotationKolaModifier(this);
    }

    public PAnnotation getAnnotation()
    {
        return this._annotation_;
    }

    public void setAnnotation(PAnnotation node)
    {
        if(this._annotation_ != null)
        {
            this._annotation_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._annotation_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._annotation_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._annotation_ == child)
        {
            this._annotation_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._annotation_ == oldChild)
        {
            setAnnotation((PAnnotation) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
