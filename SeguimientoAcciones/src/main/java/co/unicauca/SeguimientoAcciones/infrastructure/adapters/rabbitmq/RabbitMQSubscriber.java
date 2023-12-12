package co.unicauca.SeguimientoAcciones.infrastructure.adapters.rabbitmq;

import co.unicauca.SeguimientoAcciones.domain.model.Accion;
import co.unicauca.SeguimientoAcciones.domain.model.AccionUsuario;
import co.unicauca.SeguimientoAcciones.infrastructure.adapters.repositories.BolsaValoresRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMQSubscriber {
    private final BolsaValoresRepository bolsaValoresRepository;

    @Autowired
    public RabbitMQSubscriber(BolsaValoresRepository bolsaValoresRepository) {
        this.bolsaValoresRepository = bolsaValoresRepository;
    }

    @RabbitListener(queues ={"${sacavix.queue.name}"})
    public void escuchar (@Payload String message){
        log.info("Mensaje recibido: {} ",message);

        Accion accion = bolsaValoresRepository.findAction(message);

        if(accion != null){
            if (accion.getPrecioActual() > accion.getPrecioAnterior())
                log.info("El precio de la accion {} ha subido",accion.getNombreAccion());
            else if (accion.getPrecioActual() < accion.getPrecioAnterior())
                log.info("El precio de la accion {} ha bajado",accion.getNombreAccion());
            else
                log.info("El precio de la accion {} se ha mantenido",accion.getNombreAccion());
        } else {
            log.info("La accion {} no existe",message);
        }
    }
}