/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TForKeyword extends Token
{
    public TForKeyword()
    {
        super.setText("for");
    }

    public TForKeyword(int line, int pos)
    {
        super.setText("for");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TForKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTForKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TForKeyword text.");
    }
}
