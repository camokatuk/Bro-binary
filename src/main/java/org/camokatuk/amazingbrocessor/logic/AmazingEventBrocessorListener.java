package org.camokatuk.amazingbrocessor.logic;

import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import org.camokatuk.amazingbrocessor.logic.event.CharEvent;
import org.camokatuk.amazingbrocessor.logic.event.WordEvent;

public class AmazingEventBrocessorListener extends GlobalKeyAdapter
{
    private final AmazingEventProcessor amazingEventProcessor;

    private StringBuilder wordBuffer = new StringBuilder();

    public AmazingEventBrocessorListener(AmazingEventProcessor amazingEventProcessor)
    {
        this.amazingEventProcessor = amazingEventProcessor;
    }

    @Override
    public void keyReleased(GlobalKeyEvent event)
    {
        amazingEventProcessor.register(new CharEvent(event.isControlPressed(), event.getKeyChar()));

        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_SPACE)
        {
            amazingEventProcessor.register(new WordEvent(wordBuffer.toString()));
            wordBuffer = new StringBuilder();
        }
        else
        {
            wordBuffer.append(event.getKeyChar());
        }
    }
}
