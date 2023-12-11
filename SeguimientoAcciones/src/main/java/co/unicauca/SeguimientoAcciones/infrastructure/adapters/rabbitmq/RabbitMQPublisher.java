package co.unicauca.SeguimientoAcciones.infrastructure.adapters.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class RabbitMQPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    //Se encarga de enviar un objeto a la cola
    public void send(Object message){
        rabbitTemplate.convertAndSend(queue.getName(),message);
    }
}