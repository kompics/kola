/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TGotoKeyword extends Token
{
    public TGotoKeyword()
    {
        super.setText("goto");
    }

    public TGotoKeyword(int line, int pos)
    {
        super.setText("goto");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TGotoKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTGotoKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TGotoKeyword text.");
    }
}
