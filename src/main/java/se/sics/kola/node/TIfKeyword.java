/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TIfKeyword extends Token
{
    public TIfKeyword()
    {
        super.setText("if");
    }

    public TIfKeyword(int line, int pos)
    {
        super.setText("if");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TIfKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTIfKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TIfKeyword text.");
    }
}
