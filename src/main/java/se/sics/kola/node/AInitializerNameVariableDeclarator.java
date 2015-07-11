/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AInitializerNameVariableDeclarator extends PVariableDeclarator
{
    private PVariableDeclaratorId _variableDeclaratorId_;
    private PName _name_;

    public AInitializerNameVariableDeclarator()
    {
        // Constructor
    }

    public AInitializerNameVariableDeclarator(
        @SuppressWarnings("hiding") PVariableDeclaratorId _variableDeclaratorId_,
        @SuppressWarnings("hiding") PName _name_)
    {
        // Constructor
        setVariableDeclaratorId(_variableDeclaratorId_);

        setName(_name_);

    }

    @Override
    public Object clone()
    {
        return new AInitializerNameVariableDeclarator(
            cloneNode(this._variableDeclaratorId_),
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

        if(this._name_ == oldChild)
        {
            setName((PName) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
