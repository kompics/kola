/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AJavaCompilationUnit extends PJavaCompilationUnit
{
    private PCompilationUnit _compilationUnit_;

    public AJavaCompilationUnit()
    {
        // Constructor
    }

    public AJavaCompilationUnit(
        @SuppressWarnings("hiding") PCompilationUnit _compilationUnit_)
    {
        // Constructor
        setCompilationUnit(_compilationUnit_);

    }

    @Override
    public Object clone()
    {
        return new AJavaCompilationUnit(
            cloneNode(this._compilationUnit_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAJavaCompilationUnit(this);
    }

    public PCompilationUnit getCompilationUnit()
    {
        return this._compilationUnit_;
    }

    public void setCompilationUnit(PCompilationUnit node)
    {
        if(this._compilationUnit_ != null)
        {
            this._compilationUnit_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._compilationUnit_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._compilationUnit_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._compilationUnit_ == child)
        {
            this._compilationUnit_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._compilationUnit_ == oldChild)
        {
            setCompilationUnit((PCompilationUnit) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
