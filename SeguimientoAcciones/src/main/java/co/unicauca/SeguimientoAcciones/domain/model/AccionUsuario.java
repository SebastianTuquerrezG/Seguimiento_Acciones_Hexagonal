package co.unicauca.SeguimientoAcciones.domain.model;

import co.unicauca.SeguimientoAcciones.infrastructure.adapters.rabbitmq.RabbitMQPublisher;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
public class AccionUsuario implements IObserver{
    private long UmbralInferior;
    private long UmbralSuperior;
    private Usuario usuario;
    private Accion accion;
    private RabbitMQPublisher publisher = new RabbitMQPublisher();

    @Override
    public void notificar(String nombreAccion, long precioActual) {
        if(UmbralInferior>precioActual){
            Notificacion notificacion = new Notificacion();
            notificacion.setIdUsuario(usuario.getId());
            notificacion.setTitulo("Umbral Rebasado!!");
            notificacion.setDescripcion("La accion "+nombreAccion+" ha rebasado el umbral inferior");
            //usuario.getListNotificaciones().add(notificacion);
            publisher.send(notificacion);
        }else if(UmbralSuperior<precioActual){
            Notificacion notificacion = new Notificacion();
            notificacion.setIdUsuario(usuario.getId());
            notificacion.setTitulo("Umbral Rebasado!!");
            notificacion.setDescripcion("La accion "+nombreAccion+" ha rebasado el umbral superior");
            //usuario.getListNotificaciones().add(notificacion);
            publisher.send(notificacion);
        }
    }
}
