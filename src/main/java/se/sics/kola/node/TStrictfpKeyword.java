/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TStrictfpKeyword extends Token
{
    public TStrictfpKeyword()
    {
        super.setText("strictfp");
    }

    public TStrictfpKeyword(int line, int pos)
    {
        super.setText("strictfp");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TStrictfpKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTStrictfpKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TStrictfpKeyword text.");
    }
}
