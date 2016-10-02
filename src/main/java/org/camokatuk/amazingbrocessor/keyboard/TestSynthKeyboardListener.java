package org.camokatuk.amazingbrocessor.keyboard;

import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import org.apache.log4j.Logger;
import org.camokatuk.amazingbrocessor.broc.BrocessorHttpCommandFactory;
import org.camokatuk.amazingbrocessor.broc.BrocessorHttpTransport;

import java.text.DecimalFormat;

public class TestSynthKeyboardListener extends GlobalKeyAdapter
{
    private static final Logger LOGGER = Logger.getLogger(TestSynthKeyboardListener.class);

    private final Process brocessorProcess;
    private final BrocessorHttpTransport brocessorHttpTransport = new BrocessorHttpTransport();
    private final BrocessorHttpCommandFactory brocessorHttpCommandFactory = new BrocessorHttpCommandFactory();

    private double hackSynthValue = 1;

    public TestSynthKeyboardListener(Process brocessorProcess)
    {
        this.brocessorProcess = brocessorProcess;
        brocessorHttpTransport.pushCommand(brocessorHttpCommandFactory.deviceState("synth", 0, "freq", "1"));
    }

    @Override
    public void keyPressed(GlobalKeyEvent event)
    {
        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_ESCAPE)
        {
            brocessorProcess.destroy();
        }

        if (GlobalKeyEventUtil.isDigit(event) && event.isControlPressed())
        {
            brocessorHttpTransport.pushCommand(brocessorHttpCommandFactory.open(String.valueOf(GlobalKeyEventUtil.toDigit(event))));

        }

        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_SPACE)
        {
            brocessorHttpTransport.pushCommand(brocessorHttpCommandFactory.play());
        }

        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_D)
        {
            hackSynthValue = Math.min(0.6, hackSynthValue + 0.1);
            brocessorHttpTransport.pushCommand(brocessorHttpCommandFactory.deviceState("synth", 0, "freq", new DecimalFormat("#.0").format(hackSynthValue)));
        }

        if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_A)
        {
            hackSynthValue = Math.max(0, hackSynthValue - 0.1);
            brocessorHttpTransport.pushCommand(brocessorHttpCommandFactory.deviceState("synth", 0, "freq", new DecimalFormat("#.0").format(hackSynthValue)));
        }


    }

}
