package co.unicauca.SeguimientoAcciones.infrastructure.adapters.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMQSubscriber {
    @RabbitListener(queues ={"${sacavix.queue.name}"})
    public void escuchar (@Payload String message){
        log.info("Mensaje recibido: {} ",message);
    }
}
