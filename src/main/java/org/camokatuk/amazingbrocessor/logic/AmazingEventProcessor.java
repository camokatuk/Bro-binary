package org.camokatuk.amazingbrocessor.logic;

import org.apache.log4j.Logger;
import org.camokatuk.amazingbrocessor.broc.BrocessorHttpTransport;

import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AmazingEventProcessor
{
    private static final Logger LOGGER = Logger.getLogger(AmazingEventProcessor.class);

    private final BrocessorHttpTransport brocessorHttpTransport = new BrocessorHttpTransport();

    private Queue<AmazingEvent> eventQueue = new ConcurrentLinkedQueue<>();
    private final AmazingEventMapper amazingEventMapper;

    public AmazingEventProcessor(AmazingEventMapper amazingEventMapper)
    {
        this.amazingEventMapper = amazingEventMapper;
    }

    public void register(AmazingEvent event)
    {
        eventQueue.add(event);
        amazingEventMapper.map(event).stream().forEach(brocessorHttpTransport::pushCommand);
        LOGGER.debug("Registered " + event.getType() + ": " + event.getStringValue());
    }

    public Optional<AmazingEvent> nextEvent()
    {
        return Optional.ofNullable(eventQueue.poll());
    }
}
