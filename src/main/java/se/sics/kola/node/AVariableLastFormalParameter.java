/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AVariableLastFormalParameter extends PLastFormalParameter
{
    private PFormalParameter _formalParameter_;

    public AVariableLastFormalParameter()
    {
        // Constructor
    }

    public AVariableLastFormalParameter(
        @SuppressWarnings("hiding") PFormalParameter _formalParameter_)
    {
        // Constructor
        setFormalParameter(_formalParameter_);

    }

    @Override
    public Object clone()
    {
        return new AVariableLastFormalParameter(
            cloneNode(this._formalParameter_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVariableLastFormalParameter(this);
    }

    public PFormalParameter getFormalParameter()
    {
        return this._formalParameter_;
    }

    public void setFormalParameter(PFormalParameter node)
    {
        if(this._formalParameter_ != null)
        {
            this._formalParameter_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._formalParameter_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._formalParameter_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._formalParameter_ == child)
        {
            this._formalParameter_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._formalParameter_ == oldChild)
        {
            setFormalParameter((PFormalParameter) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
