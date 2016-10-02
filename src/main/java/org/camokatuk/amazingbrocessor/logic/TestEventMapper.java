package org.camokatuk.amazingbrocessor.logic;

import org.apache.commons.lang.StringUtils;
import org.camokatuk.amazingbrocessor.broc.BrocessorHttpCommandFactory;
import org.camokatuk.amazingbrocessor.broc.command.BrocessorHttpCommand;
import org.camokatuk.amazingbrocessor.logic.event.CharEvent;
import org.camokatuk.amazingbrocessor.logic.event.WordEvent;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TestEventMapper extends AmazingEventMapper
{
    private final BrocessorHttpCommandFactory brocessorHttpCommandFactory = new BrocessorHttpCommandFactory();

    private double hackSynthValue = 1;

    @Override
    public List<BrocessorHttpCommand> map(CharEvent event)
    {
        List<BrocessorHttpCommand> commands = new ArrayList<>();
        if (StringUtils.isNumeric(event.getStringValue()) && event.isCtrl())
        {
            String testPatchNumber = event.getStringValue();
            commands.add(brocessorHttpCommandFactory.open(testPatchNumber));
        }
        else if (event.getChar() == ' ')
        {
            commands.add(brocessorHttpCommandFactory.playPause());
        }
        else if (event.getChar() == 'd')
        {
            hackSynthValue = Math.min(0.6, hackSynthValue + 0.1);
            commands.add(brocessorHttpCommandFactory.deviceState("synth", 0, "freq", new DecimalFormat("#.0").format(hackSynthValue)));
        }
        else if (event.getChar() == 'a')
        {
            hackSynthValue = Math.max(0, hackSynthValue - 0.1);
            commands.add(brocessorHttpCommandFactory.deviceState("synth", 0, "freq", new DecimalFormat("#.0").format(hackSynthValue)));
        }

        return commands;
    }


    @Override
    public List<BrocessorHttpCommand> map(WordEvent event)
    {
        return new ArrayList<>();
    }
}
