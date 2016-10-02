package org.camokatuk.amazingbrocessor.broc.command;

public abstract class BrocessorGlobalHttpCommand extends AbstractBrocessorHttpCommand
{
    private String target = "global";
    private String command;

    public BrocessorGlobalHttpCommand(String command)
    {
        this.command = command;
    }
}
