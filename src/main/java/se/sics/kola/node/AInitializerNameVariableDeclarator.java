/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AInitializerNameVariableDeclarator extends PVariableDeclarator
{
    private PVariableDeclaratorId _variableDeclaratorId_;
    private TAssign _assign_;
    private PName _name_;

    public AInitializerNameVariableDeclarator()
    {
        // Constructor
    }

    public AInitializerNameVariableDeclarator(
        @SuppressWarnings("hiding") PVariableDeclaratorId _variableDeclaratorId_,
        @SuppressWarnings("hiding") TAssign _assign_,
        @SuppressWarnings("hiding") PName _name_)
    {
        // Constructor
        setVariableDeclaratorId(_variableDeclaratorId_);

        setAssign(_assign_);

        setName(_name_);

    }

    @Override
    public Object clone()
    {
        return new AInitializerNameVariableDeclarator(
            cloneNode(this._variableDeclaratorId_),
            cloneNode(this._assign_),
            cloneNode(this._name_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInitializerNameVariableDeclarator(this);
    }

    public PVariableDeclaratorId getVariableDeclaratorId()
    {
        return this._variableDeclaratorId_;
    }

    public void setVariableDeclaratorId(PVariableDeclaratorId node)
    {
        if(this._variableDeclaratorId_ != null)
        {
            this._variableDeclaratorId_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._variableDeclaratorId_ = node;
    }

    public TAssign getAssign()
    {
        return this._assign_;
    }

    public void setAssign(TAssign node)
    {
        if(this._assign_ != null)
        {
            this._assign_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._assign_ = node;
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._variableDeclaratorId_)
            + toString(this._assign_)
            + toString(this._name_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._variableDeclaratorId_ == child)
        {
            this._variableDeclaratorId_ = null;
            return;
        }

        if(this._assign_ == child)
        {
            this._assign_ = null;
            return;
        }

        if(this._name_ == child)
        {
            this._name_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._variableDeclaratorId_ == oldChild)
        {
            setVariableDeclaratorId((PVariableDeclaratorId) newChild);
            return;
        }

        if(this._assign_ == oldChild)
        {
            setAssign((TAssign) newChild);
            return;
        }

        if(this._name_ == oldChild)
        {
            setName((PName) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}