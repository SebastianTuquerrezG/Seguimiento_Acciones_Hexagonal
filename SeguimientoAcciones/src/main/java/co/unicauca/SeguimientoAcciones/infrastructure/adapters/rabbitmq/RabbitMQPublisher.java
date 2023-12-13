package co.unicauca.SeguimientoAcciones.infrastructure.adapters.rabbitmq;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQPublisher {
    private final RabbitTemplate rabbitTemplate = new RabbitTemplate();

    public RabbitMQPublisher() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setExchange("cola1");
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
    }


    public void send(Object message){
        rabbitTemplate.convertAndSend("cola1", "cola1",message);
    }
}
