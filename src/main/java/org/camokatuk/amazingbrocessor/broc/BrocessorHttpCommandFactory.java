package org.camokatuk.amazingbrocessor.broc;

import org.camokatuk.amazingbrocessor.broc.command.BrocessorHttpCommand;
import org.camokatuk.amazingbrocessor.broc.command.BrocessorOpenPatchHttpCommand;
import org.camokatuk.amazingbrocessor.broc.command.BrocessorPlaybackHttpCommand;
import org.camokatuk.amazingbrocessor.broc.command.DeviceCommand;

public class BrocessorHttpCommandFactory
{
    public BrocessorHttpCommand open(String patchName)
    {
        return new BrocessorOpenPatchHttpCommand("patches/camokatuk/" + patchName + ".bro");
    }

    public BrocessorHttpCommand playPause()
    {
        return new BrocessorPlaybackHttpCommand("play");
    }

    public BrocessorHttpCommand deviceState(String target, int index, String control, String value)
    {
        return new DeviceCommand(target, index, control, value);
    }
}

