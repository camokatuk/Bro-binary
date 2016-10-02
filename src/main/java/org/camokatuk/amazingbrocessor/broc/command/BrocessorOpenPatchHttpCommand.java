package org.camokatuk.amazingbrocessor.broc.command;

public class BrocessorOpenPatchHttpCommand extends GlobalCommand
{
    private String path;

    public BrocessorOpenPatchHttpCommand(String path)
    {
        super("open");
        this.path = path;
    }
}
