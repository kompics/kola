/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import java.util.*;
import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ACatchTryStatement extends PTryStatement
{
    private PBlock _block_;
    private final LinkedList<PCatchClause> _catchClause_ = new LinkedList<PCatchClause>();

    public ACatchTryStatement()
    {
        // Constructor
    }

    public ACatchTryStatement(
        @SuppressWarnings("hiding") PBlock _block_,
        @SuppressWarnings("hiding") List<?> _catchClause_)
    {
        // Constructor
        setBlock(_block_);

        setCatchClause(_catchClause_);

    }

    @Override
    public Object clone()
    {
        return new ACatchTryStatement(
            cloneNode(this._block_),
            cloneList(this._catchClause_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACatchTryStatement(this);
    }

    public PBlock getBlock()
    {
        return this._block_;
    }

    public void setBlock(PBlock node)
    {
        if(this._block_ != null)
        {
            this._block_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._block_ = node;
    }

    public LinkedList<PCatchClause> getCatchClause()
    {
        return this._catchClause_;
    }

    public void setCatchClause(List<?> list)
    {
        for(PCatchClause e : this._catchClause_)
        {
            e.parent(null);
        }
        this._catchClause_.clear();

        for(Object obj_e : list)
        {
            PCatchClause e = (PCatchClause) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._catchClause_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._block_)
            + toString(this._catchClause_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._block_ == child)
        {
            this._block_ = null;
            return;
        }

        if(this._catchClause_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._block_ == oldChild)
        {
            setBlock((PBlock) newChild);
            return;
        }

        for(ListIterator<PCatchClause> i = this._catchClause_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PCatchClause) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}