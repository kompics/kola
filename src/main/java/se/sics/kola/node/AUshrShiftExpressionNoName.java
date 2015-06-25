/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AUshrShiftExpressionNoName extends PShiftExpressionNoName
{
    private PShiftExpressionNoName _shiftExpressionNoName_;
    private TUshr _ushr_;
    private PAdditiveExpressionNoName _additiveExpressionNoName_;

    public AUshrShiftExpressionNoName()
    {
        // Constructor
    }

    public AUshrShiftExpressionNoName(
        @SuppressWarnings("hiding") PShiftExpressionNoName _shiftExpressionNoName_,
        @SuppressWarnings("hiding") TUshr _ushr_,
        @SuppressWarnings("hiding") PAdditiveExpressionNoName _additiveExpressionNoName_)
    {
        // Constructor
        setShiftExpressionNoName(_shiftExpressionNoName_);

        setUshr(_ushr_);

        setAdditiveExpressionNoName(_additiveExpressionNoName_);

    }

    @Override
    public Object clone()
    {
        return new AUshrShiftExpressionNoName(
            cloneNode(this._shiftExpressionNoName_),
            cloneNode(this._ushr_),
            cloneNode(this._additiveExpressionNoName_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAUshrShiftExpressionNoName(this);
    }

    public PShiftExpressionNoName getShiftExpressionNoName()
    {
        return this._shiftExpressionNoName_;
    }

    public void setShiftExpressionNoName(PShiftExpressionNoName node)
    {
        if(this._shiftExpressionNoName_ != null)
        {
            this._shiftExpressionNoName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._shiftExpressionNoName_ = node;
    }

    public TUshr getUshr()
    {
        return this._ushr_;
    }

    public void setUshr(TUshr node)
    {
        if(this._ushr_ != null)
        {
            this._ushr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ushr_ = node;
    }

    public PAdditiveExpressionNoName getAdditiveExpressionNoName()
    {
        return this._additiveExpressionNoName_;
    }

    public void setAdditiveExpressionNoName(PAdditiveExpressionNoName node)
    {
        if(this._additiveExpressionNoName_ != null)
        {
            this._additiveExpressionNoName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._additiveExpressionNoName_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._shiftExpressionNoName_)
            + toString(this._ushr_)
            + toString(this._additiveExpressionNoName_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._shiftExpressionNoName_ == child)
        {
            this._shiftExpressionNoName_ = null;
            return;
        }

        if(this._ushr_ == child)
        {
            this._ushr_ = null;
            return;
        }

        if(this._additiveExpressionNoName_ == child)
        {
            this._additiveExpressionNoName_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._shiftExpressionNoName_ == oldChild)
        {
            setShiftExpressionNoName((PShiftExpressionNoName) newChild);
            return;
        }

        if(this._ushr_ == oldChild)
        {
            setUshr((TUshr) newChild);
            return;
        }

        if(this._additiveExpressionNoName_ == oldChild)
        {
            setAdditiveExpressionNoName((PAdditiveExpressionNoName) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}