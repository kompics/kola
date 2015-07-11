/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AVariableBlockStatement extends PBlockStatement
{
    private PLocalVariableDeclaration _localVariableDeclaration_;

    public AVariableBlockStatement()
    {
        // Constructor
    }

    public AVariableBlockStatement(
        @SuppressWarnings("hiding") PLocalVariableDeclaration _localVariableDeclaration_)
    {
        // Constructor
        setLocalVariableDeclaration(_localVariableDeclaration_);

    }

    @Override
    public Object clone()
    {
        return new AVariableBlockStatement(
            cloneNode(this._localVariableDeclaration_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVariableBlockStatement(this);
    }

    public PLocalVariableDeclaration getLocalVariableDeclaration()
    {
        return this._localVariableDeclaration_;
    }

    public void setLocalVariableDeclaration(PLocalVariableDeclaration node)
    {
        if(this._localVariableDeclaration_ != null)
        {
            this._localVariableDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._localVariableDeclaration_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._localVariableDeclaration_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._localVariableDeclaration_ == child)
        {
            this._localVariableDeclaration_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._localVariableDeclaration_ == oldChild)
        {
            setLocalVariableDeclaration((PLocalVariableDeclaration) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
