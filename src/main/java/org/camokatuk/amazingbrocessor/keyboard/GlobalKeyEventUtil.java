package org.camokatuk.amazingbrocessor.keyboard;

import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class GlobalKeyEventUtil
{
    public static boolean isDigit(GlobalKeyEvent event)
    {
        return event.getVirtualKeyCode() <= GlobalKeyEvent.VK_9 && event.getVirtualKeyCode() >= GlobalKeyEvent.VK_0;
    }

    public static int toDigit(GlobalKeyEvent event)
    {
        return event.getVirtualKeyCode() - 48;
    }
}
