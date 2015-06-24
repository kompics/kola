/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ASuperMethodInvocation extends PMethodInvocation
{
    private TSuperKeyword _superKeyword_;
    private TDot _dot_;
    private PNonWildTypeArguments _nonWildTypeArguments_;
    private TIdentifier _identifier_;
    private TLPar _lPar_;
    private PArgumentList _argumentList_;
    private TRPar _rPar_;

    public ASuperMethodInvocation()
    {
        // Constructor
    }

    public ASuperMethodInvocation(
        @SuppressWarnings("hiding") TSuperKeyword _superKeyword_,
        @SuppressWarnings("hiding") TDot _dot_,
        @SuppressWarnings("hiding") PNonWildTypeArguments _nonWildTypeArguments_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") TLPar _lPar_,
        @SuppressWarnings("hiding") PArgumentList _argumentList_,
        @SuppressWarnings("hiding") TRPar _rPar_)
    {
        // Constructor
        setSuperKeyword(_superKeyword_);

        setDot(_dot_);

        setNonWildTypeArguments(_nonWildTypeArguments_);

        setIdentifier(_identifier_);

        setLPar(_lPar_);

        setArgumentList(_argumentList_);

        setRPar(_rPar_);

    }

    @Override
    public Object clone()
    {
        return new ASuperMethodInvocation(
            cloneNode(this._superKeyword_),
            cloneNode(this._dot_),
            cloneNode(this._nonWildTypeArguments_),
            cloneNode(this._identifier_),
            cloneNode(this._lPar_),
            cloneNode(this._argumentList_),
            cloneNode(this._rPar_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASuperMethodInvocation(this);
    }

    public TSuperKeyword getSuperKeyword()
    {
        return this._superKeyword_;
    }

    public void setSuperKeyword(TSuperKeyword node)
    {
        if(this._superKeyword_ != null)
        {
            this._superKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._superKeyword_ = node;
    }

    public TDot getDot()
    {
        return this._dot_;
    }

    public void setDot(TDot node)
    {
        if(this._dot_ != null)
        {
            this._dot_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dot_ = node;
    }

    public PNonWildTypeArguments getNonWildTypeArguments()
    {
        return this._nonWildTypeArguments_;
    }

    public void setNonWildTypeArguments(PNonWildTypeArguments node)
    {
        if(this._nonWildTypeArguments_ != null)
        {
            this._nonWildTypeArguments_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._nonWildTypeArguments_ = node;
    }

    public TIdentifier getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
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

    public PArgumentList getArgumentList()
    {
        return this._argumentList_;
    }

    public void setArgumentList(PArgumentList node)
    {
        if(this._argumentList_ != null)
        {
            this._argumentList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._argumentList_ = node;
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
            + toString(this._superKeyword_)
            + toString(this._dot_)
            + toString(this._nonWildTypeArguments_)
            + toString(this._identifier_)
            + toString(this._lPar_)
            + toString(this._argumentList_)
            + toString(this._rPar_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._superKeyword_ == child)
        {
            this._superKeyword_ = null;
            return;
        }

        if(this._dot_ == child)
        {
            this._dot_ = null;
            return;
        }

        if(this._nonWildTypeArguments_ == child)
        {
            this._nonWildTypeArguments_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._lPar_ == child)
        {
            this._lPar_ = null;
            return;
        }

        if(this._argumentList_ == child)
        {
            this._argumentList_ = null;
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
        if(this._superKeyword_ == oldChild)
        {
            setSuperKeyword((TSuperKeyword) newChild);
            return;
        }

        if(this._dot_ == oldChild)
        {
            setDot((TDot) newChild);
            return;
        }

        if(this._nonWildTypeArguments_ == oldChild)
        {
            setNonWildTypeArguments((PNonWildTypeArguments) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        if(this._lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(this._argumentList_ == oldChild)
        {
            setArgumentList((PArgumentList) newChild);
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
