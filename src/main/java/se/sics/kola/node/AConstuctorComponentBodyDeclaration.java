/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AConstuctorComponentBodyDeclaration extends PComponentBodyDeclaration
{
    private PConstructorDeclaration _constructorDeclaration_;

    public AConstuctorComponentBodyDeclaration()
    {
        // Constructor
    }

    public AConstuctorComponentBodyDeclaration(
        @SuppressWarnings("hiding") PConstructorDeclaration _constructorDeclaration_)
    {
        // Constructor
        setConstructorDeclaration(_constructorDeclaration_);

    }

    @Override
    public Object clone()
    {
        return new AConstuctorComponentBodyDeclaration(
            cloneNode(this._constructorDeclaration_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAConstuctorComponentBodyDeclaration(this);
    }

    public PConstructorDeclaration getConstructorDeclaration()
    {
        return this._constructorDeclaration_;
    }

    public void setConstructorDeclaration(PConstructorDeclaration node)
    {
        if(this._constructorDeclaration_ != null)
        {
            this._constructorDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._constructorDeclaration_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._constructorDeclaration_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._constructorDeclaration_ == child)
        {
            this._constructorDeclaration_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._constructorDeclaration_ == oldChild)
        {
            setConstructorDeclaration((PConstructorDeclaration) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
