/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import java.util.*;
import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ANormalAnnotation extends PNormalAnnotation
{
    private PName _name_;
    private final LinkedList<PElementValuePair> _elementValuePair_ = new LinkedList<PElementValuePair>();

    public ANormalAnnotation()
    {
        // Constructor
    }

    public ANormalAnnotation(
        @SuppressWarnings("hiding") PName _name_,
        @SuppressWarnings("hiding") List<?> _elementValuePair_)
    {
        // Constructor
        setName(_name_);

        setElementValuePair(_elementValuePair_);

    }

    @Override
    public Object clone()
    {
        return new ANormalAnnotation(
            cloneNode(this._name_),
            cloneList(this._elementValuePair_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANormalAnnotation(this);
    }

    public PName getName()
    {
        return this._name_;
    }

    public void setName(PName node)
    {
        if(this._name_ != null)
        {
            this._name_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._name_ = node;
    }

    public LinkedList<PElementValuePair> getElementValuePair()
    {
        return this._elementValuePair_;
    }

    public void setElementValuePair(List<?> list)
    {
        for(PElementValuePair e : this._elementValuePair_)
        {
            e.parent(null);
        }
        this._elementValuePair_.clear();

        for(Object obj_e : list)
        {
            PElementValuePair e = (PElementValuePair) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._elementValuePair_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._name_)
            + toString(this._elementValuePair_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._name_ == child)
        {
            this._name_ = null;
            return;
        }

        if(this._elementValuePair_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._name_ == oldChild)
        {
            setName((PName) newChild);
            return;
        }

        for(ListIterator<PElementValuePair> i = this._elementValuePair_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PElementValuePair) newChild);
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
