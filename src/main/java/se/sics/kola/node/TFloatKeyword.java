/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TFloatKeyword extends Token
{
    public TFloatKeyword()
    {
        super.setText("float");
    }

    public TFloatKeyword(int line, int pos)
    {
        super.setText("float");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TFloatKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTFloatKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TFloatKeyword text.");
    }
}
