package de.floriansymmank.pong.port;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("pong")
    private String pongQueue;

    @Value("ping")
    private String pingQueue;

    @Value("exchange")
    private String exchange;

    @Value("pong_routing_key")
    private String pongRoutingKey;

    @Value("ping_routing_key")
    private String pingRoutingKey;

    @Bean
    public Queue pongQueue(){
        return new Queue(pongQueue);
    }

    @Bean
    public Queue pingQueue(){
        return new Queue(pingQueue);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding pongBinding(){
        return BindingBuilder
                .bind(pongQueue())
                .to(exchange())
                .with(pongRoutingKey);
    }

    @Bean
    public Binding pingBinding(){
        return BindingBuilder
                .bind(pingQueue())
                .to(exchange())
                .with(pingRoutingKey);
    }
}
