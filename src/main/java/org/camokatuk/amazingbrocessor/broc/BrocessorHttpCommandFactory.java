package org.camokatuk.amazingbrocessor.broc;

import org.camokatuk.amazingbrocessor.broc.command.*;

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

    public BrocessorHttpCommand mixerSolo(int index, int totalInputs, int soloChannel)
    {
        MixerCommand.State[] states = new MixerCommand.State[totalInputs];
        for (int i = 0; i < totalInputs; i++)
        {
            states[i] = MixerCommand.State.in(i, i == soloChannel ? "1" : "0");
        }
        return new MixerCommand(index, states);
    }
}

