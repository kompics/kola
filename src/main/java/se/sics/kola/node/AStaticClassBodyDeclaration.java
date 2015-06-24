/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AStaticClassBodyDeclaration extends PClassBodyDeclaration
{
    private PStaticInitializer _staticInitializer_;

    public AStaticClassBodyDeclaration()
    {
        // Constructor
    }

    public AStaticClassBodyDeclaration(
        @SuppressWarnings("hiding") PStaticInitializer _staticInitializer_)
    {
        // Constructor
        setStaticInitializer(_staticInitializer_);

    }

    @Override
    public Object clone()
    {
        return new AStaticClassBodyDeclaration(
            cloneNode(this._staticInitializer_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAStaticClassBodyDeclaration(this);
    }

    public PStaticInitializer getStaticInitializer()
    {
        return this._staticInitializer_;
    }

    public void setStaticInitializer(PStaticInitializer node)
    {
        if(this._staticInitializer_ != null)
        {
            this._staticInitializer_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._staticInitializer_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._staticInitializer_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._staticInitializer_ == child)
        {
            this._staticInitializer_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._staticInitializer_ == oldChild)
        {
            setStaticInitializer((PStaticInitializer) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
