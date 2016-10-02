package org.camokatuk.amazingbrocessor;

import org.apache.log4j.Logger;
import org.camokatuk.amazingbrocessor.keyboard.KeyboardHookService;
import org.camokatuk.amazingbrocessor.keyboard.TestSynthKeyboardListener;

public class Main
{
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] as)
    {
        try
        {
            final Process brocProc = new ProcessBuilder("Brocessor.exe").start();
            KeyboardHookService keyboardHookService = new KeyboardHookService();
            keyboardHookService.start(new TestSynthKeyboardListener(brocProc));
        }
        catch (Exception e)
        {
            LOGGER.error("Oh fuck off!", e);
        }
    }
}
