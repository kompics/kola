/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AThrows extends PThrows
{
    private TThrowsKeyword _throwsKeyword_;
    private PExceptionTypeList _exceptionTypeList_;

    public AThrows()
    {
        // Constructor
    }

    public AThrows(
        @SuppressWarnings("hiding") TThrowsKeyword _throwsKeyword_,
        @SuppressWarnings("hiding") PExceptionTypeList _exceptionTypeList_)
    {
        // Constructor
        setThrowsKeyword(_throwsKeyword_);

        setExceptionTypeList(_exceptionTypeList_);

    }

    @Override
    public Object clone()
    {
        return new AThrows(
            cloneNode(this._throwsKeyword_),
            cloneNode(this._exceptionTypeList_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAThrows(this);
    }

    public TThrowsKeyword getThrowsKeyword()
    {
        return this._throwsKeyword_;
    }

    public void setThrowsKeyword(TThrowsKeyword node)
    {
        if(this._throwsKeyword_ != null)
        {
            this._throwsKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._throwsKeyword_ = node;
    }

    public PExceptionTypeList getExceptionTypeList()
    {
        return this._exceptionTypeList_;
    }

    public void setExceptionTypeList(PExceptionTypeList node)
    {
        if(this._exceptionTypeList_ != null)
        {
            this._exceptionTypeList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exceptionTypeList_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._throwsKeyword_)
            + toString(this._exceptionTypeList_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._throwsKeyword_ == child)
        {
            this._throwsKeyword_ = null;
            return;
        }

        if(this._exceptionTypeList_ == child)
        {
            this._exceptionTypeList_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._throwsKeyword_ == oldChild)
        {
            setThrowsKeyword((TThrowsKeyword) newChild);
            return;
        }

        if(this._exceptionTypeList_ == oldChild)
        {
            setExceptionTypeList((PExceptionTypeList) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
