/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AVariableVariableInitializersTail extends PVariableInitializersTail
{
    private TComma _comma_;
    private PVariableInitializerNoName _variableInitializerNoName_;

    public AVariableVariableInitializersTail()
    {
        // Constructor
    }

    public AVariableVariableInitializersTail(
        @SuppressWarnings("hiding") TComma _comma_,
        @SuppressWarnings("hiding") PVariableInitializerNoName _variableInitializerNoName_)
    {
        // Constructor
        setComma(_comma_);

        setVariableInitializerNoName(_variableInitializerNoName_);

    }

    @Override
    public Object clone()
    {
        return new AVariableVariableInitializersTail(
            cloneNode(this._comma_),
            cloneNode(this._variableInitializerNoName_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVariableVariableInitializersTail(this);
    }

    public TComma getComma()
    {
        return this._comma_;
    }

    public void setComma(TComma node)
    {
        if(this._comma_ != null)
        {
            this._comma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._comma_ = node;
    }

    public PVariableInitializerNoName getVariableInitializerNoName()
    {
        return this._variableInitializerNoName_;
    }

    public void setVariableInitializerNoName(PVariableInitializerNoName node)
    {
        if(this._variableInitializerNoName_ != null)
        {
            this._variableInitializerNoName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._variableInitializerNoName_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._comma_)
            + toString(this._variableInitializerNoName_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._comma_ == child)
        {
            this._comma_ = null;
            return;
        }

        if(this._variableInitializerNoName_ == child)
        {
            this._variableInitializerNoName_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._comma_ == oldChild)
        {
            setComma((TComma) newChild);
            return;
        }

        if(this._variableInitializerNoName_ == oldChild)
        {
            setVariableInitializerNoName((PVariableInitializerNoName) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
