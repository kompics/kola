/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AHandlerHandlingDeclaration extends PHandlingDeclaration
{
    private PHandlerDeclaration _handlerDeclaration_;

    public AHandlerHandlingDeclaration()
    {
        // Constructor
    }

    public AHandlerHandlingDeclaration(
        @SuppressWarnings("hiding") PHandlerDeclaration _handlerDeclaration_)
    {
        // Constructor
        setHandlerDeclaration(_handlerDeclaration_);

    }

    @Override
    public Object clone()
    {
        return new AHandlerHandlingDeclaration(
            cloneNode(this._handlerDeclaration_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAHandlerHandlingDeclaration(this);
    }

    public PHandlerDeclaration getHandlerDeclaration()
    {
        return this._handlerDeclaration_;
    }

    public void setHandlerDeclaration(PHandlerDeclaration node)
    {
        if(this._handlerDeclaration_ != null)
        {
            this._handlerDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._handlerDeclaration_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._handlerDeclaration_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._handlerDeclaration_ == child)
        {
            this._handlerDeclaration_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._handlerDeclaration_ == oldChild)
        {
            setHandlerDeclaration((PHandlerDeclaration) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}