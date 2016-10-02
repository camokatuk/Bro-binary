package org.camokatuk.amazingbrocessor.broc;

import org.camokatuk.amazingbrocessor.broc.command.BrocessorHttpCommand;

import java.io.IOException;

public interface BrocessorTransport<C extends BrocessorHttpCommand>
{
    void pushCommand(C brocessorCommand) throws IOException;
}
