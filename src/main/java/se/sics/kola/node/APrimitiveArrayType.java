/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import java.util.*;
import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class APrimitiveArrayType extends PArrayType
{
    private PPrimitiveType _primitiveType_;
    private final LinkedList<PDim> _dim_ = new LinkedList<PDim>();

    public APrimitiveArrayType()
    {
        // Constructor
    }

    public APrimitiveArrayType(
        @SuppressWarnings("hiding") PPrimitiveType _primitiveType_,
        @SuppressWarnings("hiding") List<?> _dim_)
    {
        // Constructor
        setPrimitiveType(_primitiveType_);

        setDim(_dim_);

    }

    @Override
    public Object clone()
    {
        return new APrimitiveArrayType(
            cloneNode(this._primitiveType_),
            cloneList(this._dim_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPrimitiveArrayType(this);
    }

    public PPrimitiveType getPrimitiveType()
    {
        return this._primitiveType_;
    }

    public void setPrimitiveType(PPrimitiveType node)
    {
        if(this._primitiveType_ != null)
        {
            this._primitiveType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._primitiveType_ = node;
    }

    public LinkedList<PDim> getDim()
    {
        return this._dim_;
    }

    public void setDim(List<?> list)
    {
        for(PDim e : this._dim_)
        {
            e.parent(null);
        }
        this._dim_.clear();

        for(Object obj_e : list)
        {
            PDim e = (PDim) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._dim_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._primitiveType_)
            + toString(this._dim_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._primitiveType_ == child)
        {
            this._primitiveType_ = null;
            return;
        }

        if(this._dim_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._primitiveType_ == oldChild)
        {
            setPrimitiveType((PPrimitiveType) newChild);
            return;
        }

        for(ListIterator<PDim> i = this._dim_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PDim) newChild);
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
