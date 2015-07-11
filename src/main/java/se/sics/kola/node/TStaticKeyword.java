/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TStaticKeyword extends Token
{
    public TStaticKeyword()
    {
        super.setText("static");
    }

    public TStaticKeyword(int line, int pos)
    {
        super.setText("static");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TStaticKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTStaticKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TStaticKeyword text.");
    }
}
