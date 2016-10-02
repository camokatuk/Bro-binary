package org.camokatuk.amazingbrocessor.logic.event;

import org.camokatuk.amazingbrocessor.logic.AmazingEvent;

public class CharEvent implements AmazingEvent
{
    private final boolean ctrl;
    private final char character;

    public CharEvent(boolean ctrl, char character)
    {
        this.ctrl = ctrl;
        this.character = character;
    }

    @Override
    public String getStringValue()
    {
        return new String(new char[]{character});
    }

    public char getChar()
    {
        return character;
    }

    @Override
    public Type getType()
    {
        return Type.CHAR;
    }

    public boolean isCtrl()
    {
        return ctrl;
    }
}
