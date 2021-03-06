/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TFinallyKeyword extends Token
{
    public TFinallyKeyword()
    {
        super.setText("finally");
    }

    public TFinallyKeyword(int line, int pos)
    {
        super.setText("finally");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TFinallyKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTFinallyKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TFinallyKeyword text.");
    }
}
