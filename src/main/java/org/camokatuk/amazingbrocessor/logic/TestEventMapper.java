package org.camokatuk.amazingbrocessor.logic;

import org.apache.commons.lang.StringUtils;
import org.camokatuk.amazingbrocessor.broc.BrocessorHttpCommandFactory;
import org.camokatuk.amazingbrocessor.broc.command.BrocessorHttpCommand;
import org.camokatuk.amazingbrocessor.logic.event.CharEvent;
import org.camokatuk.amazingbrocessor.logic.event.WordEvent;

import java.util.ArrayList;
import java.util.List;

public class TestEventMapper extends AmazingEventMapper
{
    private final BrocessorHttpCommandFactory brocessorHttpCommandFactory = new BrocessorHttpCommandFactory();

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
            commands.add(brocessorHttpCommandFactory.mixerSolo(1, 2, 0));
        }
        else if (event.getChar() == 'a')
        {
            //            commands.add(brocessorHttpCommandFactory.deviceState("synth", 0, "freq", new DecimalFormat("#.0").format(hackSynthValue)));
            commands.add(brocessorHttpCommandFactory.mixerSolo(1, 2, 1));
        }

        return commands;
    }


    @Override
    public List<BrocessorHttpCommand> map(WordEvent event)
    {
        return new ArrayList<>();
    }
}
