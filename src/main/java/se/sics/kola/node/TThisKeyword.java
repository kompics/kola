/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TThisKeyword extends Token
{
    public TThisKeyword()
    {
        super.setText("this");
    }

    public TThisKeyword(int line, int pos)
    {
        super.setText("this");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TThisKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTThisKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TThisKeyword text.");
    }
}