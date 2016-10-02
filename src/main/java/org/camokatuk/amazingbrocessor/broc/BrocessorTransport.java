package org.camokatuk.amazingbrocessor.broc;

import java.io.IOException;

public interface BrocessorTransport<C extends BrocessorCommand>
{
    void pushCommand(C brocessorCommand) throws IOException;
}
