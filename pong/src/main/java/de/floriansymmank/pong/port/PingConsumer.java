package de.floriansymmank.pong.port;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PingConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(PingConsumer.class);

    @Autowired
    PongProducer pongProducer;

    @RabbitListener(queues = {"ping"})
    public void consume(String message) {
        LOGGER.info(String.format("Received message -> %s", message));
        pongProducer.sendMessage("Pong");
    }
}
