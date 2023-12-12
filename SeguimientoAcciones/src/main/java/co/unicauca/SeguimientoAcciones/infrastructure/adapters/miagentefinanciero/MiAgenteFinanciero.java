package co.unicauca.SeguimientoAcciones.infrastructure.adapters.miagentefinanciero;


import co.unicauca.SeguimientoAcciones.SeguimientoAccionesApplication;
import co.unicauca.SeguimientoAcciones.domain.model.Notificacion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.Payload;

@Slf4j
public class MiAgenteFinanciero {

    private final int id = 21; //Id de usuario
    //public static void main(String[] args) {
        //SpringApplication.run(SeguimientoAccionesApplication.class, args);
    //}

    @RabbitListener(queues ={"cola1"})
    public void escuchar (@Payload Object notificacion){

        Notificacion auxNotificacion = ((Notificacion) notificacion);
        if(auxNotificacion.getIdUsuario()==id){
            log.info("Ha llegado una notificacion: {} ",auxNotificacion.getDescripcion());
        }
    }
}
