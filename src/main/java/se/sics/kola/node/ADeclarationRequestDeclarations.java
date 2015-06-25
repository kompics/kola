/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ADeclarationRequestDeclarations extends PRequestDeclarations
{
    private PRequestDeclaration _requestDeclaration_;

    public ADeclarationRequestDeclarations()
    {
        // Constructor
    }

    public ADeclarationRequestDeclarations(
        @SuppressWarnings("hiding") PRequestDeclaration _requestDeclaration_)
    {
        // Constructor
        setRequestDeclaration(_requestDeclaration_);

    }

    @Override
    public Object clone()
    {
        return new ADeclarationRequestDeclarations(
            cloneNode(this._requestDeclaration_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADeclarationRequestDeclarations(this);
    }

    public PRequestDeclaration getRequestDeclaration()
    {
        return this._requestDeclaration_;
    }

    public void setRequestDeclaration(PRequestDeclaration node)
    {
        if(this._requestDeclaration_ != null)
        {
            this._requestDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._requestDeclaration_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._requestDeclaration_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._requestDeclaration_ == child)
        {
            this._requestDeclaration_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._requestDeclaration_ == oldChild)
        {
            setRequestDeclaration((PRequestDeclaration) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}