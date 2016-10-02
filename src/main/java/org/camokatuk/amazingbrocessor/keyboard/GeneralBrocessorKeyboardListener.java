package org.camokatuk.amazingbrocessor.keyboard;

import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import org.apache.log4j.Logger;

public class GeneralBrocessorKeyboardListener extends GlobalKeyAdapter
{
    private static final Logger LOGGER = Logger.getLogger(GeneralBrocessorKeyboardListener.class);

    private final Process brocessorProcess;

    public GeneralBrocessorKeyboardListener(Process brocessorProcess)
    {
        this.brocessorProcess = brocessorProcess;
    }

    @Override
    public void keyPressed(GlobalKeyEvent event)
    {
        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE)
        {
            LOGGER.info("Killing Brocessor...");
            brocessorProcess.destroy();
        }
    }

}
