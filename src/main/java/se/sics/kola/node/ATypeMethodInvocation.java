/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import java.util.*;
import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class ATypeMethodInvocation extends PMethodInvocation
{
    private PName _name_;
    private final LinkedList<PReferenceType> _nonWildTypeArguments_ = new LinkedList<PReferenceType>();
    private TIdentifier _identifier_;
    private final LinkedList<PArgument> _argument_ = new LinkedList<PArgument>();

    public ATypeMethodInvocation()
    {
        // Constructor
    }

    public ATypeMethodInvocation(
        @SuppressWarnings("hiding") PName _name_,
        @SuppressWarnings("hiding") List<?> _nonWildTypeArguments_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") List<?> _argument_)
    {
        // Constructor
        setName(_name_);

        setNonWildTypeArguments(_nonWildTypeArguments_);

        setIdentifier(_identifier_);

        setArgument(_argument_);

    }

    @Override
    public Object clone()
    {
        return new ATypeMethodInvocation(
            cloneNode(this._name_),
            cloneList(this._nonWildTypeArguments_),
            cloneNode(this._identifier_),
            cloneList(this._argument_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATypeMethodInvocation(this);
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

    public LinkedList<PReferenceType> getNonWildTypeArguments()
    {
        return this._nonWildTypeArguments_;
    }

    public void setNonWildTypeArguments(List<?> list)
    {
        for(PReferenceType e : this._nonWildTypeArguments_)
        {
            e.parent(null);
        }
        this._nonWildTypeArguments_.clear();

        for(Object obj_e : list)
        {
            PReferenceType e = (PReferenceType) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._nonWildTypeArguments_.add(e);
        }
    }

    public TIdentifier getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
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
            + toString(this._name_)
            + toString(this._nonWildTypeArguments_)
            + toString(this._identifier_)
            + toString(this._argument_);
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

        if(this._nonWildTypeArguments_.remove(child))
        {
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

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
        if(this._name_ == oldChild)
        {
            setName((PName) newChild);
            return;
        }

        for(ListIterator<PReferenceType> i = this._nonWildTypeArguments_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PReferenceType) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

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
