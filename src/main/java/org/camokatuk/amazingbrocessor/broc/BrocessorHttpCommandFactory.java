package org.camokatuk.amazingbrocessor.broc;

import org.camokatuk.amazingbrocessor.broc.command.AbstractBrocessorHttpCommand;
import org.camokatuk.amazingbrocessor.broc.command.BrocessorDeviceHttpCommand;
import org.camokatuk.amazingbrocessor.broc.command.BrocessorOpenPatchHttpCommand;
import org.camokatuk.amazingbrocessor.broc.command.BrocessorPlaybackHttpCommand;

public class BrocessorHttpCommandFactory
{
    public AbstractBrocessorHttpCommand open(String patchName)
    {
        return new BrocessorOpenPatchHttpCommand("patches/camokatuk/" + patchName + ".bro");
    }

    public AbstractBrocessorHttpCommand stop()
    {
        return new BrocessorPlaybackHttpCommand("stop");
    }

    public AbstractBrocessorHttpCommand play()
    {
        return new BrocessorPlaybackHttpCommand("play");
    }

    public AbstractBrocessorHttpCommand deviceState(String target, int index, String control, String value)
    {
        return new BrocessorDeviceHttpCommand(target, index, control, value);
    }
}

