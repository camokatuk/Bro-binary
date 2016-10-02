package org.camokatuk.amazingbrocessor.broc.command;

public abstract class GlobalCommand implements BrocessorHttpCommand
{
    private String target = "global";
    private String command;

    public GlobalCommand(String command)
    {
        this.command = command;
    }
}
