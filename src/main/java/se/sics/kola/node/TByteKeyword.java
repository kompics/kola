/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TByteKeyword extends Token
{
    public TByteKeyword()
    {
        super.setText("byte");
    }

    public TByteKeyword(int line, int pos)
    {
        super.setText("byte");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TByteKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTByteKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TByteKeyword text.");
    }
}