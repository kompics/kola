/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TProvidesKeyword extends Token
{
    public TProvidesKeyword()
    {
        super.setText("provides");
    }

    public TProvidesKeyword(int line, int pos)
    {
        super.setText("provides");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TProvidesKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTProvidesKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TProvidesKeyword text.");
    }
}
