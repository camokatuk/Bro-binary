package org.camokatuk.amazingbrocessor;

import org.apache.log4j.Logger;

public class Main
{
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] as)
    {
        Process brocProc = null;
        try
        {
            brocProc = new ProcessBuilder("Brocessor.exe").start();
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
