package org.camokatuk.amazingbrocessor;

import org.apache.log4j.Logger;
import org.camokatuk.amazingbrocessor.keyboard.GeneralBrocessorKeyboardListener;
import org.camokatuk.amazingbrocessor.keyboard.KeyboardHookService;
import org.camokatuk.amazingbrocessor.logic.AmazingEventBrocessorListener;
import org.camokatuk.amazingbrocessor.logic.AmazingEventProcessor;
import org.camokatuk.amazingbrocessor.logic.TestEventMapper;

public class Main
{
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] as)
    {
        try
        {
            final Process brocProc = new ProcessBuilder("Brocessor.exe").start();
            KeyboardHookService keyboardHookService = new KeyboardHookService();

            AmazingEventProcessor eventQueue = new AmazingEventProcessor(new TestEventMapper());

            keyboardHookService.start(new GeneralBrocessorKeyboardListener(brocProc), new AmazingEventBrocessorListener(eventQueue));
        }
        catch (Exception e)
        {
            LOGGER.error("Oh fuck off!", e);
        }
    }
}
