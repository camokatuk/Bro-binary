package org.camokatuk.amazingbrocessor.logic.event;

import org.camokatuk.amazingbrocessor.logic.AmazingEvent;

public class WordEvent implements AmazingEvent
{
    private final String word;

    public WordEvent(String word)
    {
        this.word = word;
    }

    @Override
    public String getStringValue()
    {
        return word;
    }

    @Override
    public Type getType()
    {
        return Type.WORD;
    }
}
