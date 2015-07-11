/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AInterfaceInterfaceDeclaration extends PInterfaceDeclaration
{
    private PNormalInterfaceDeclaration _normalInterfaceDeclaration_;

    public AInterfaceInterfaceDeclaration()
    {
        // Constructor
    }

    public AInterfaceInterfaceDeclaration(
        @SuppressWarnings("hiding") PNormalInterfaceDeclaration _normalInterfaceDeclaration_)
    {
        // Constructor
        setNormalInterfaceDeclaration(_normalInterfaceDeclaration_);

    }

    @Override
    public Object clone()
    {
        return new AInterfaceInterfaceDeclaration(
            cloneNode(this._normalInterfaceDeclaration_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInterfaceInterfaceDeclaration(this);
    }

    public PNormalInterfaceDeclaration getNormalInterfaceDeclaration()
    {
        return this._normalInterfaceDeclaration_;
    }

    public void setNormalInterfaceDeclaration(PNormalInterfaceDeclaration node)
    {
        if(this._normalInterfaceDeclaration_ != null)
        {
            this._normalInterfaceDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._normalInterfaceDeclaration_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._normalInterfaceDeclaration_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._normalInterfaceDeclaration_ == child)
        {
            this._normalInterfaceDeclaration_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._normalInterfaceDeclaration_ == oldChild)
        {
            setNormalInterfaceDeclaration((PNormalInterfaceDeclaration) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
