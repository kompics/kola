/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ARequestPortBodyDeclaration extends PPortBodyDeclaration
{
    private PRequestsDeclaration _requestsDeclaration_;

    public ARequestPortBodyDeclaration()
    {
        // Constructor
    }

    public ARequestPortBodyDeclaration(
        @SuppressWarnings("hiding") PRequestsDeclaration _requestsDeclaration_)
    {
        // Constructor
        setRequestsDeclaration(_requestsDeclaration_);

    }

    @Override
    public Object clone()
    {
        return new ARequestPortBodyDeclaration(
            cloneNode(this._requestsDeclaration_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARequestPortBodyDeclaration(this);
    }

    public PRequestsDeclaration getRequestsDeclaration()
    {
        return this._requestsDeclaration_;
    }

    public void setRequestsDeclaration(PRequestsDeclaration node)
    {
        if(this._requestsDeclaration_ != null)
        {
            this._requestsDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._requestsDeclaration_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._requestsDeclaration_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._requestsDeclaration_ == child)
        {
            this._requestsDeclaration_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._requestsDeclaration_ == oldChild)
        {
            setRequestsDeclaration((PRequestsDeclaration) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
