package co.unicauca.SeguimientoAcciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "co.unicauca.SeguimientoAcciones")
public class SeguimientoAccionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeguimientoAccionesApplication.class, args);
	}

}
