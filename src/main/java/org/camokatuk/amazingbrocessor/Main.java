package org.camokatuk.amazingbrocessor;

import org.apache.log4j.Logger;
import org.camokatuk.amazingbrocessor.broc.BrocessorHttpCommandFactory;
import org.camokatuk.amazingbrocessor.broc.BrocessorHttpTransport;

public class Main
{
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] as)
    {
        Process brocProc = null;
        try
        {
            brocProc = new ProcessBuilder("Brocessor.exe").start();
            BrocessorHttpTransport brocessorHttpTransport = new BrocessorHttpTransport();

            BrocessorHttpCommandFactory brocessorHttpCommandFactory = new BrocessorHttpCommandFactory();
            brocessorHttpTransport.pushCommand(brocessorHttpCommandFactory.open("1"));
            Thread.sleep(1000);
            brocessorHttpTransport.pushCommand(brocessorHttpCommandFactory.deviceState("synth", 0, "function", "cos(x)"));
            Thread.sleep(1000);
            brocessorHttpTransport.pushCommand(brocessorHttpCommandFactory.play());
        }
        catch (Exception e)
        {
            LOGGER.error("Oh fuck off!", e);
        }
        //        finally
        //        {
        //            if (brocProc != null)
        //            {
        //                brocProc.destroy();
        //            }
        //        }
    }
}
