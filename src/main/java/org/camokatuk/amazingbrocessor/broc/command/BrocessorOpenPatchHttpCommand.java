package org.camokatuk.amazingbrocessor.broc.command;

public class BrocessorOpenPatchHttpCommand extends BrocessorGlobalHttpCommand
{
    private String path;

    public BrocessorOpenPatchHttpCommand(String path)
    {
        super("open");
        this.path = path;
    }
}
