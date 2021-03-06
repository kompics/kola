/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TPlus extends Token
{
    public TPlus()
    {
        super.setText("+");
    }

    public TPlus(int line, int pos)
    {
        super.setText("+");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TPlus(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTPlus(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TPlus text.");
    }
}
