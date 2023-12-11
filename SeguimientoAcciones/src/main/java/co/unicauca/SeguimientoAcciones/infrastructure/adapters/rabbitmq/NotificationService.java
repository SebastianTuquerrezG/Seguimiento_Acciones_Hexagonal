package co.unicauca.SeguimientoAcciones.infrastructure.adapters.rabbitmq;

import co.unicauca.SeguimientoAcciones.SeguimientoAccionesApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationService {
    public static void main(String[] args) {
        SpringApplication.run(NotificationService.class, args);
    }
}
