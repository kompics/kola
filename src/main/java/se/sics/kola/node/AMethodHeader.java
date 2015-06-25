/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AMethodHeader extends PMethodHeader
{
    private PModifiers _modifiers_;
    private PTypeParameters _typeParameters_;
    private PResult _result_;
    private PMethodDeclarator _methodDeclarator_;
    private PThrows _throws_;

    public AMethodHeader()
    {
        // Constructor
    }

    public AMethodHeader(
        @SuppressWarnings("hiding") PModifiers _modifiers_,
        @SuppressWarnings("hiding") PTypeParameters _typeParameters_,
        @SuppressWarnings("hiding") PResult _result_,
        @SuppressWarnings("hiding") PMethodDeclarator _methodDeclarator_,
        @SuppressWarnings("hiding") PThrows _throws_)
    {
        // Constructor
        setModifiers(_modifiers_);

        setTypeParameters(_typeParameters_);

        setResult(_result_);

        setMethodDeclarator(_methodDeclarator_);

        setThrows(_throws_);

    }

    @Override
    public Object clone()
    {
        return new AMethodHeader(
            cloneNode(this._modifiers_),
            cloneNode(this._typeParameters_),
            cloneNode(this._result_),
            cloneNode(this._methodDeclarator_),
            cloneNode(this._throws_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMethodHeader(this);
    }

    public PModifiers getModifiers()
    {
        return this._modifiers_;
    }

    public void setModifiers(PModifiers node)
    {
        if(this._modifiers_ != null)
        {
            this._modifiers_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._modifiers_ = node;
    }

    public PTypeParameters getTypeParameters()
    {
        return this._typeParameters_;
    }

    public void setTypeParameters(PTypeParameters node)
    {
        if(this._typeParameters_ != null)
        {
            this._typeParameters_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._typeParameters_ = node;
    }

    public PResult getResult()
    {
        return this._result_;
    }

    public void setResult(PResult node)
    {
        if(this._result_ != null)
        {
            this._result_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._result_ = node;
    }

    public PMethodDeclarator getMethodDeclarator()
    {
        return this._methodDeclarator_;
    }

    public void setMethodDeclarator(PMethodDeclarator node)
    {
        if(this._methodDeclarator_ != null)
        {
            this._methodDeclarator_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._methodDeclarator_ = node;
    }

    public PThrows getThrows()
    {
        return this._throws_;
    }

    public void setThrows(PThrows node)
    {
        if(this._throws_ != null)
        {
            this._throws_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._throws_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._modifiers_)
            + toString(this._typeParameters_)
            + toString(this._result_)
            + toString(this._methodDeclarator_)
            + toString(this._throws_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._modifiers_ == child)
        {
            this._modifiers_ = null;
            return;
        }

        if(this._typeParameters_ == child)
        {
            this._typeParameters_ = null;
            return;
        }

        if(this._result_ == child)
        {
            this._result_ = null;
            return;
        }

        if(this._methodDeclarator_ == child)
        {
            this._methodDeclarator_ = null;
            return;
        }

        if(this._throws_ == child)
        {
            this._throws_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._modifiers_ == oldChild)
        {
            setModifiers((PModifiers) newChild);
            return;
        }

        if(this._typeParameters_ == oldChild)
        {
            setTypeParameters((PTypeParameters) newChild);
            return;
        }

        if(this._result_ == oldChild)
        {
            setResult((PResult) newChild);
            return;
        }

        if(this._methodDeclarator_ == oldChild)
        {
            setMethodDeclarator((PMethodDeclarator) newChild);
            return;
        }

        if(this._throws_ == oldChild)
        {
            setThrows((PThrows) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}