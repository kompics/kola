/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TCaseKeyword extends Token
{
    public TCaseKeyword()
    {
        super.setText("case");
    }

    public TCaseKeyword(int line, int pos)
    {
        super.setText("case");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TCaseKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTCaseKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TCaseKeyword text.");
    }
}