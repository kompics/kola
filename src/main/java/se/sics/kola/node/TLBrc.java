/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TLBrc extends Token
{
    public TLBrc()
    {
        super.setText("{");
    }

    public TLBrc(int line, int pos)
    {
        super.setText("{");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TLBrc(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTLBrc(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TLBrc text.");
    }
}
