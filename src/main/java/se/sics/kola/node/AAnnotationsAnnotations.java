/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AAnnotationsAnnotations extends PAnnotations
{
    private PAnnotations _annotations_;
    private PAnnotation _annotation_;

    public AAnnotationsAnnotations()
    {
        // Constructor
    }

    public AAnnotationsAnnotations(
        @SuppressWarnings("hiding") PAnnotations _annotations_,
        @SuppressWarnings("hiding") PAnnotation _annotation_)
    {
        // Constructor
        setAnnotations(_annotations_);

        setAnnotation(_annotation_);

    }

    @Override
    public Object clone()
    {
        return new AAnnotationsAnnotations(
            cloneNode(this._annotations_),
            cloneNode(this._annotation_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAnnotationsAnnotations(this);
    }

    public PAnnotations getAnnotations()
    {
        return this._annotations_;
    }

    public void setAnnotations(PAnnotations node)
    {
        if(this._annotations_ != null)
        {
            this._annotations_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._annotations_ = node;
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
            + toString(this._annotations_)
            + toString(this._annotation_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._annotations_ == child)
        {
            this._annotations_ = null;
            return;
        }

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
        if(this._annotations_ == oldChild)
        {
            setAnnotations((PAnnotations) newChild);
            return;
        }

        if(this._annotation_ == oldChild)
        {
            setAnnotation((PAnnotation) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
