/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TSynchronizedKeyword extends Token
{
    public TSynchronizedKeyword()
    {
        super.setText("synchronized");
    }

    public TSynchronizedKeyword(int line, int pos)
    {
        super.setText("synchronized");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TSynchronizedKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTSynchronizedKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TSynchronizedKeyword text.");
    }
}