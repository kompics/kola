/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TPublicKeyword extends Token
{
    public TPublicKeyword()
    {
        super.setText("public");
    }

    public TPublicKeyword(int line, int pos)
    {
        super.setText("public");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TPublicKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTPublicKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TPublicKeyword text.");
    }
}