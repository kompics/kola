/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AInstanceClassBodyDeclaration extends PClassBodyDeclaration
{
    private PInstanceInitializer _instanceInitializer_;

    public AInstanceClassBodyDeclaration()
    {
        // Constructor
    }

    public AInstanceClassBodyDeclaration(
        @SuppressWarnings("hiding") PInstanceInitializer _instanceInitializer_)
    {
        // Constructor
        setInstanceInitializer(_instanceInitializer_);

    }

    @Override
    public Object clone()
    {
        return new AInstanceClassBodyDeclaration(
            cloneNode(this._instanceInitializer_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInstanceClassBodyDeclaration(this);
    }

    public PInstanceInitializer getInstanceInitializer()
    {
        return this._instanceInitializer_;
    }

    public void setInstanceInitializer(PInstanceInitializer node)
    {
        if(this._instanceInitializer_ != null)
        {
            this._instanceInitializer_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._instanceInitializer_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._instanceInitializer_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._instanceInitializer_ == child)
        {
            this._instanceInitializer_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._instanceInitializer_ == oldChild)
        {
            setInstanceInitializer((PInstanceInitializer) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}