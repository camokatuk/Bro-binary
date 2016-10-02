package org.camokatuk.amazingbrocessor.logic;

public interface AmazingEvent
{
    public static enum Type
    {
        CHAR,
        WORD
    }

    String getStringValue();

    Type getType();
}
