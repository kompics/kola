/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ADeclarationClassBodyDeclarations extends PClassBodyDeclarations
{
    private PClassBodyDeclaration _classBodyDeclaration_;

    public ADeclarationClassBodyDeclarations()
    {
        // Constructor
    }

    public ADeclarationClassBodyDeclarations(
        @SuppressWarnings("hiding") PClassBodyDeclaration _classBodyDeclaration_)
    {
        // Constructor
        setClassBodyDeclaration(_classBodyDeclaration_);

    }

    @Override
    public Object clone()
    {
        return new ADeclarationClassBodyDeclarations(
            cloneNode(this._classBodyDeclaration_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADeclarationClassBodyDeclarations(this);
    }

    public PClassBodyDeclaration getClassBodyDeclaration()
    {
        return this._classBodyDeclaration_;
    }

    public void setClassBodyDeclaration(PClassBodyDeclaration node)
    {
        if(this._classBodyDeclaration_ != null)
        {
            this._classBodyDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._classBodyDeclaration_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._classBodyDeclaration_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._classBodyDeclaration_ == child)
        {
            this._classBodyDeclaration_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._classBodyDeclaration_ == oldChild)
        {
            setClassBodyDeclaration((PClassBodyDeclaration) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}