/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TInstanceofKeyword extends Token
{
    public TInstanceofKeyword()
    {
        super.setText("instanceof");
    }

    public TInstanceofKeyword(int line, int pos)
    {
        super.setText("instanceof");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TInstanceofKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTInstanceofKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TInstanceofKeyword text.");
    }
}
