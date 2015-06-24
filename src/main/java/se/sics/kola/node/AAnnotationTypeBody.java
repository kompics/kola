/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AAnnotationTypeBody extends PAnnotationTypeBody
{
    private TLBrc _lBrc_;
    private PAnnotationTypeElementDeclarations _annotationTypeElementDeclarations_;
    private TRBrc _rBrc_;

    public AAnnotationTypeBody()
    {
        // Constructor
    }

    public AAnnotationTypeBody(
        @SuppressWarnings("hiding") TLBrc _lBrc_,
        @SuppressWarnings("hiding") PAnnotationTypeElementDeclarations _annotationTypeElementDeclarations_,
        @SuppressWarnings("hiding") TRBrc _rBrc_)
    {
        // Constructor
        setLBrc(_lBrc_);

        setAnnotationTypeElementDeclarations(_annotationTypeElementDeclarations_);

        setRBrc(_rBrc_);

    }

    @Override
    public Object clone()
    {
        return new AAnnotationTypeBody(
            cloneNode(this._lBrc_),
            cloneNode(this._annotationTypeElementDeclarations_),
            cloneNode(this._rBrc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAnnotationTypeBody(this);
    }

    public TLBrc getLBrc()
    {
        return this._lBrc_;
    }

    public void setLBrc(TLBrc node)
    {
        if(this._lBrc_ != null)
        {
            this._lBrc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lBrc_ = node;
    }

    public PAnnotationTypeElementDeclarations getAnnotationTypeElementDeclarations()
    {
        return this._annotationTypeElementDeclarations_;
    }

    public void setAnnotationTypeElementDeclarations(PAnnotationTypeElementDeclarations node)
    {
        if(this._annotationTypeElementDeclarations_ != null)
        {
            this._annotationTypeElementDeclarations_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._annotationTypeElementDeclarations_ = node;
    }

    public TRBrc getRBrc()
    {
        return this._rBrc_;
    }

    public void setRBrc(TRBrc node)
    {
        if(this._rBrc_ != null)
        {
            this._rBrc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rBrc_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._lBrc_)
            + toString(this._annotationTypeElementDeclarations_)
            + toString(this._rBrc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._lBrc_ == child)
        {
            this._lBrc_ = null;
            return;
        }

        if(this._annotationTypeElementDeclarations_ == child)
        {
            this._annotationTypeElementDeclarations_ = null;
            return;
        }

        if(this._rBrc_ == child)
        {
            this._rBrc_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._lBrc_ == oldChild)
        {
            setLBrc((TLBrc) newChild);
            return;
        }

        if(this._annotationTypeElementDeclarations_ == oldChild)
        {
            setAnnotationTypeElementDeclarations((PAnnotationTypeElementDeclarations) newChild);
            return;
        }

        if(this._rBrc_ == oldChild)
        {
            setRBrc((TRBrc) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
