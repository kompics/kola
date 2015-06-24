/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TIntegerLiteral extends Token
{
    public TIntegerLiteral(String text)
    {
        setText(text);
    }

    public TIntegerLiteral(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TIntegerLiteral(getText(), getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTIntegerLiteral(this);
    }
}
