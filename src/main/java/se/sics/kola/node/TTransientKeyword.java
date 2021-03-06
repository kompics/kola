/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TTransientKeyword extends Token
{
    public TTransientKeyword()
    {
        super.setText("transient");
    }

    public TTransientKeyword(int line, int pos)
    {
        super.setText("transient");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TTransientKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTransientKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TTransientKeyword text.");
    }
}
