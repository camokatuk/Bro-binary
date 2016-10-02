package org.camokatuk.amazingbrocessor.logic;

import org.camokatuk.amazingbrocessor.broc.command.BrocessorHttpCommand;
import org.camokatuk.amazingbrocessor.logic.event.CharEvent;
import org.camokatuk.amazingbrocessor.logic.event.WordEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class AmazingEventMapper
{
    protected abstract List<BrocessorHttpCommand> map(CharEvent event);

    protected abstract List<BrocessorHttpCommand> map(WordEvent event);

    public List<BrocessorHttpCommand> map(AmazingEvent event)
    {
        switch (event.getType())
        {
            case CHAR:
            {
                return map((CharEvent) event);
            }
            case WORD:
            {
                return map((WordEvent) event);
            }
        }
        return new ArrayList<>();
    }
}
