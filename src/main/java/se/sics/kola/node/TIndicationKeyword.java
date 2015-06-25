/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TIndicationKeyword extends Token
{
    public TIndicationKeyword()
    {
        super.setText("indication");
    }

    public TIndicationKeyword(int line, int pos)
    {
        super.setText("indication");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TIndicationKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTIndicationKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TIndicationKeyword text.");
    }
}