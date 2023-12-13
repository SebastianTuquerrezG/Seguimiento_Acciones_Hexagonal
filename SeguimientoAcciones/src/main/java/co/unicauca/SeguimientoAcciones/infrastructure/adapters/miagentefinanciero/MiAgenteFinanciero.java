package co.unicauca.SeguimientoAcciones.infrastructure.adapters.miagentefinanciero;


import co.unicauca.SeguimientoAcciones.SeguimientoAccionesApplication;
import co.unicauca.SeguimientoAcciones.domain.model.Notificacion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MiAgenteFinanciero {

    private final int id = 21; //Id de usuario que se va a notificar



    @RabbitListener(queues ={"cola1"})
    public void escuchar (@Payload Notificacion notificacion){
        try {
            Notificacion auxNotificacion = (Notificacion) notificacion;
            log.info("Ha llegado una notificacion: {} ", auxNotificacion.getDescripcion());
        } catch (Exception e) {
            log.error("Error al procesar la notificación: {}", e.getMessage());
            // Puedes agregar más manejo de errores según tus necesidades
        }
    }
}
