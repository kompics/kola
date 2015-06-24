/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ADeclarationIndicationDeclarations extends PIndicationDeclarations
{
    private PIndicationDeclaration _indicationDeclaration_;

    public ADeclarationIndicationDeclarations()
    {
        // Constructor
    }

    public ADeclarationIndicationDeclarations(
        @SuppressWarnings("hiding") PIndicationDeclaration _indicationDeclaration_)
    {
        // Constructor
        setIndicationDeclaration(_indicationDeclaration_);

    }

    @Override
    public Object clone()
    {
        return new ADeclarationIndicationDeclarations(
            cloneNode(this._indicationDeclaration_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADeclarationIndicationDeclarations(this);
    }

    public PIndicationDeclaration getIndicationDeclaration()
    {
        return this._indicationDeclaration_;
    }

    public void setIndicationDeclaration(PIndicationDeclaration node)
    {
        if(this._indicationDeclaration_ != null)
        {
            this._indicationDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._indicationDeclaration_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._indicationDeclaration_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._indicationDeclaration_ == child)
        {
            this._indicationDeclaration_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._indicationDeclaration_ == oldChild)
        {
            setIndicationDeclaration((PIndicationDeclaration) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
