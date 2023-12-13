package co.unicauca.SeguimientoAcciones;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "co.unicauca.SeguimientoAcciones")
public class SeguimientoAccionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeguimientoAccionesApplication.class, args);
	}

	@Bean
	public OpenAPI custonOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Seguimiento de acciones API - Spring Boot 3 ")
						.version("1.0.0")
						.description("Administración de usuarios, acciones y acciones de usuarios.")
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache 2.0").url("http://springdoc.org"))
				);
	}
}
