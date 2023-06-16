package de.floriansymmank.ping.port;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PongConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(PongConsumer.class);

    @RabbitListener(queues = {"pong"})
    public void consume(String message) {
        LOGGER.info(String.format("Received message -> %s", message));
    }
}
