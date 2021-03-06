/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import java.util.*;
import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class AMethodHeader extends PMethodHeader
{
    private final LinkedList<PModifier> _modifier_ = new LinkedList<PModifier>();
    private final LinkedList<PTypeParameter> _typeParameter_ = new LinkedList<PTypeParameter>();
    private PResult _result_;
    private PMethodDeclarator _methodDeclarator_;
    private PThrows _throws_;

    public AMethodHeader()
    {
        // Constructor
    }

    public AMethodHeader(
        @SuppressWarnings("hiding") List<?> _modifier_,
        @SuppressWarnings("hiding") List<?> _typeParameter_,
        @SuppressWarnings("hiding") PResult _result_,
        @SuppressWarnings("hiding") PMethodDeclarator _methodDeclarator_,
        @SuppressWarnings("hiding") PThrows _throws_)
    {
        // Constructor
        setModifier(_modifier_);

        setTypeParameter(_typeParameter_);

        setResult(_result_);

        setMethodDeclarator(_methodDeclarator_);

        setThrows(_throws_);

    }

    @Override
    public Object clone()
    {
        return new AMethodHeader(
            cloneList(this._modifier_),
            cloneList(this._typeParameter_),
            cloneNode(this._result_),
            cloneNode(this._methodDeclarator_),
            cloneNode(this._throws_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMethodHeader(this);
    }

    public LinkedList<PModifier> getModifier()
    {
        return this._modifier_;
    }

    public void setModifier(List<?> list)
    {
        for(PModifier e : this._modifier_)
        {
            e.parent(null);
        }
        this._modifier_.clear();

        for(Object obj_e : list)
        {
            PModifier e = (PModifier) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._modifier_.add(e);
        }
    }

    public LinkedList<PTypeParameter> getTypeParameter()
    {
        return this._typeParameter_;
    }

    public void setTypeParameter(List<?> list)
    {
        for(PTypeParameter e : this._typeParameter_)
        {
            e.parent(null);
        }
        this._typeParameter_.clear();

        for(Object obj_e : list)
        {
            PTypeParameter e = (PTypeParameter) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._typeParameter_.add(e);
        }
    }

    public PResult getResult()
    {
        return this._result_;
    }

    public void setResult(PResult node)
    {
        if(this._result_ != null)
        {
            this._result_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._result_ = node;
    }

    public PMethodDeclarator getMethodDeclarator()
    {
        return this._methodDeclarator_;
    }

    public void setMethodDeclarator(PMethodDeclarator node)
    {
        if(this._methodDeclarator_ != null)
        {
            this._methodDeclarator_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._methodDeclarator_ = node;
    }

    public PThrows getThrows()
    {
        return this._throws_;
    }

    public void setThrows(PThrows node)
    {
        if(this._throws_ != null)
        {
            this._throws_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._throws_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._modifier_)
            + toString(this._typeParameter_)
            + toString(this._result_)
            + toString(this._methodDeclarator_)
            + toString(this._throws_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._modifier_.remove(child))
        {
            return;
        }

        if(this._typeParameter_.remove(child))
        {
            return;
        }

        if(this._result_ == child)
        {
            this._result_ = null;
            return;
        }

        if(this._methodDeclarator_ == child)
        {
            this._methodDeclarator_ = null;
            return;
        }

        if(this._throws_ == child)
        {
            this._throws_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PModifier> i = this._modifier_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PModifier) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator<PTypeParameter> i = this._typeParameter_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PTypeParameter) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._result_ == oldChild)
        {
            setResult((PResult) newChild);
            return;
        }

        if(this._methodDeclarator_ == oldChild)
        {
            setMethodDeclarator((PMethodDeclarator) newChild);
            return;
        }

        if(this._throws_ == oldChild)
        {
            setThrows((PThrows) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
