/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ANormalAnnotation extends PNormalAnnotation
{
    private TAt _at_;
    private PName _name_;
    private TLPar _lPar_;
    private PElementValuePairs _elementValuePairs_;
    private TRPar _rPar_;

    public ANormalAnnotation()
    {
        // Constructor
    }

    public ANormalAnnotation(
        @SuppressWarnings("hiding") TAt _at_,
        @SuppressWarnings("hiding") PName _name_,
        @SuppressWarnings("hiding") TLPar _lPar_,
        @SuppressWarnings("hiding") PElementValuePairs _elementValuePairs_,
        @SuppressWarnings("hiding") TRPar _rPar_)
    {
        // Constructor
        setAt(_at_);

        setName(_name_);

        setLPar(_lPar_);

        setElementValuePairs(_elementValuePairs_);

        setRPar(_rPar_);

    }

    @Override
    public Object clone()
    {
        return new ANormalAnnotation(
            cloneNode(this._at_),
            cloneNode(this._name_),
            cloneNode(this._lPar_),
            cloneNode(this._elementValuePairs_),
            cloneNode(this._rPar_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANormalAnnotation(this);
    }

    public TAt getAt()
    {
        return this._at_;
    }

    public void setAt(TAt node)
    {
        if(this._at_ != null)
        {
            this._at_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._at_ = node;
    }

    public PName getName()
    {
        return this._name_;
    }

    public void setName(PName node)
    {
        if(this._name_ != null)
        {
            this._name_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._name_ = node;
    }

    public TLPar getLPar()
    {
        return this._lPar_;
    }

    public void setLPar(TLPar node)
    {
        if(this._lPar_ != null)
        {
            this._lPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lPar_ = node;
    }

    public PElementValuePairs getElementValuePairs()
    {
        return this._elementValuePairs_;
    }

    public void setElementValuePairs(PElementValuePairs node)
    {
        if(this._elementValuePairs_ != null)
        {
            this._elementValuePairs_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._elementValuePairs_ = node;
    }

    public TRPar getRPar()
    {
        return this._rPar_;
    }

    public void setRPar(TRPar node)
    {
        if(this._rPar_ != null)
        {
            this._rPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rPar_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._at_)
            + toString(this._name_)
            + toString(this._lPar_)
            + toString(this._elementValuePairs_)
            + toString(this._rPar_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._at_ == child)
        {
            this._at_ = null;
            return;
        }

        if(this._name_ == child)
        {
            this._name_ = null;
            return;
        }

        if(this._lPar_ == child)
        {
            this._lPar_ = null;
            return;
        }

        if(this._elementValuePairs_ == child)
        {
            this._elementValuePairs_ = null;
            return;
        }

        if(this._rPar_ == child)
        {
            this._rPar_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._at_ == oldChild)
        {
            setAt((TAt) newChild);
            return;
        }

        if(this._name_ == oldChild)
        {
            setName((PName) newChild);
            return;
        }

        if(this._lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(this._elementValuePairs_ == oldChild)
        {
            setElementValuePairs((PElementValuePairs) newChild);
            return;
        }

        if(this._rPar_ == oldChild)
        {
            setRPar((TRPar) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
