/* This file was generated by SableCC (http://www.sablecc.org/). */

package se.sics.kola.node;

import se.sics.kola.analysis.*;

@SuppressWarnings("nls")
public final class TDefinitionKeyword extends Token
{
    public TDefinitionKeyword()
    {
        super.setText("definition");
    }

    public TDefinitionKeyword(int line, int pos)
    {
        super.setText("definition");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TDefinitionKeyword(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTDefinitionKeyword(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TDefinitionKeyword text.");
    }
}
