package org.camokatuk.amazingbrocessor.logic;

import org.apache.log4j.Logger;
import org.camokatuk.amazingbrocessor.broc.BrocessorHttpTransport;

public class AmazingEventProcessor
{
    private static final Logger LOGGER = Logger.getLogger(AmazingEventProcessor.class);

    private final BrocessorHttpTransport brocessorHttpTransport = new BrocessorHttpTransport();

    private final AmazingEventMapper amazingEventMapper;

    public AmazingEventProcessor(AmazingEventMapper amazingEventMapper)
    {
        this.amazingEventMapper = amazingEventMapper;
    }

    public void register(AmazingEvent event)
    {
        amazingEventMapper.map(event).stream().forEach(brocessorHttpTransport::pushCommand);
        LOGGER.debug("Registered " + event.getType() + ": " + event.getStringValue());
    }
}
