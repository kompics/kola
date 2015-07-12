/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import java.util.*;
import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AComponentInitialization extends PComponentInitialization
{
    private final LinkedList<PArgument> _argument_ = new LinkedList<PArgument>();

    public AComponentInitialization()
    {
        // Constructor
    }

    public AComponentInitialization(
        @SuppressWarnings("hiding") List<?> _argument_)
    {
        // Constructor
        setArgument(_argument_);

    }

    @Override
    public Object clone()
    {
        return new AComponentInitialization(
            cloneList(this._argument_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAComponentInitialization(this);
    }

    public LinkedList<PArgument> getArgument()
    {
        return this._argument_;
    }

    public void setArgument(List<?> list)
    {
        for(PArgument e : this._argument_)
        {
            e.parent(null);
        }
        this._argument_.clear();

        for(Object obj_e : list)
        {
            PArgument e = (PArgument) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._argument_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._argument_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._argument_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PArgument> i = this._argument_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PArgument) newChild);
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