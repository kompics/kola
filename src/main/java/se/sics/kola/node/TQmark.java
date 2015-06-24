/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TQmark extends Token
{
    public TQmark()
    {
        super.setText("?");
    }

    public TQmark(int line, int pos)
    {
        super.setText("?");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TQmark(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTQmark(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TQmark text.");
    }
}
