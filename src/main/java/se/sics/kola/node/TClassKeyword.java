/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TClassKeyword extends Token
{
    public TClassKeyword()
    {
        super.setText("class");
    }

    public TClassKeyword(int line, int pos)
    {
        super.setText("class");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TClassKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTClassKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TClassKeyword text.");
    }
}
