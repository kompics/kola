/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AConnectStatement extends PConnectStatement
{
    private TConnectKeyword _connectKeyword_;
    private TIdentifier _providedId_;
    private TRArrow _rArrow_;
    private TIdentifier _requiredId_;
    private TColon _colon_;
    private PClassType _classType_;
    private TSemi _semi_;

    public AConnectStatement()
    {
        // Constructor
    }

    public AConnectStatement(
        @SuppressWarnings("hiding") TConnectKeyword _connectKeyword_,
        @SuppressWarnings("hiding") TIdentifier _providedId_,
        @SuppressWarnings("hiding") TRArrow _rArrow_,
        @SuppressWarnings("hiding") TIdentifier _requiredId_,
        @SuppressWarnings("hiding") TColon _colon_,
        @SuppressWarnings("hiding") PClassType _classType_,
        @SuppressWarnings("hiding") TSemi _semi_)
    {
        // Constructor
        setConnectKeyword(_connectKeyword_);

        setProvidedId(_providedId_);

        setRArrow(_rArrow_);

        setRequiredId(_requiredId_);

        setColon(_colon_);

        setClassType(_classType_);

        setSemi(_semi_);

    }

    @Override
    public Object clone()
    {
        return new AConnectStatement(
            cloneNode(this._connectKeyword_),
            cloneNode(this._providedId_),
            cloneNode(this._rArrow_),
            cloneNode(this._requiredId_),
            cloneNode(this._colon_),
            cloneNode(this._classType_),
            cloneNode(this._semi_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAConnectStatement(this);
    }

    public TConnectKeyword getConnectKeyword()
    {
        return this._connectKeyword_;
    }

    public void setConnectKeyword(TConnectKeyword node)
    {
        if(this._connectKeyword_ != null)
        {
            this._connectKeyword_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._connectKeyword_ = node;
    }

    public TIdentifier getProvidedId()
    {
        return this._providedId_;
    }

    public void setProvidedId(TIdentifier node)
    {
        if(this._providedId_ != null)
        {
            this._providedId_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._providedId_ = node;
    }

    public TRArrow getRArrow()
    {
        return this._rArrow_;
    }

    public void setRArrow(TRArrow node)
    {
        if(this._rArrow_ != null)
        {
            this._rArrow_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rArrow_ = node;
    }

    public TIdentifier getRequiredId()
    {
        return this._requiredId_;
    }

    public void setRequiredId(TIdentifier node)
    {
        if(this._requiredId_ != null)
        {
            this._requiredId_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._requiredId_ = node;
    }

    public TColon getColon()
    {
        return this._colon_;
    }

    public void setColon(TColon node)
    {
        if(this._colon_ != null)
        {
            this._colon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._colon_ = node;
    }

    public PClassType getClassType()
    {
        return this._classType_;
    }

    public void setClassType(PClassType node)
    {
        if(this._classType_ != null)
        {
            this._classType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._classType_ = node;
    }

    public TSemi getSemi()
    {
        return this._semi_;
    }

    public void setSemi(TSemi node)
    {
        if(this._semi_ != null)
        {
            this._semi_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semi_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._connectKeyword_)
            + toString(this._providedId_)
            + toString(this._rArrow_)
            + toString(this._requiredId_)
            + toString(this._colon_)
            + toString(this._classType_)
            + toString(this._semi_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._connectKeyword_ == child)
        {
            this._connectKeyword_ = null;
            return;
        }

        if(this._providedId_ == child)
        {
            this._providedId_ = null;
            return;
        }

        if(this._rArrow_ == child)
        {
            this._rArrow_ = null;
            return;
        }

        if(this._requiredId_ == child)
        {
            this._requiredId_ = null;
            return;
        }

        if(this._colon_ == child)
        {
            this._colon_ = null;
            return;
        }

        if(this._classType_ == child)
        {
            this._classType_ = null;
            return;
        }

        if(this._semi_ == child)
        {
            this._semi_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._connectKeyword_ == oldChild)
        {
            setConnectKeyword((TConnectKeyword) newChild);
            return;
        }

        if(this._providedId_ == oldChild)
        {
            setProvidedId((TIdentifier) newChild);
            return;
        }

        if(this._rArrow_ == oldChild)
        {
            setRArrow((TRArrow) newChild);
            return;
        }

        if(this._requiredId_ == oldChild)
        {
            setRequiredId((TIdentifier) newChild);
            return;
        }

        if(this._colon_ == oldChild)
        {
            setColon((TColon) newChild);
            return;
        }

        if(this._classType_ == oldChild)
        {
            setClassType((PClassType) newChild);
            return;
        }

        if(this._semi_ == oldChild)
        {
            setSemi((TSemi) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
