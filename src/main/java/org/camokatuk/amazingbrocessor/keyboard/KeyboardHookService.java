package org.camokatuk.amazingbrocessor.keyboard;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import org.apache.log4j.Logger;

public class KeyboardHookService
{
    private static final Logger LOGGER = Logger.getLogger(KeyboardHookService.class);

    private GlobalKeyboardHook keyboardHook;

    public void start(GlobalKeyAdapter... globalKeyAdapter)
    {
        keyboardHook = new GlobalKeyboardHook();

        for (GlobalKeyAdapter listener : globalKeyAdapter)
        {
            keyboardHook.addKeyListener(listener);
        }

        keyboardHook.addKeyListener(new GlobalKeyAdapter()
        {
            @Override
            public void keyPressed(GlobalKeyEvent event)
            {
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE)
                {
                    keyboardHook.shutdownHook();
                }
            }

            @Override
            public void keyReleased(GlobalKeyEvent event)
            {
                LOGGER.debug(event);
            }
        });
    }
}
