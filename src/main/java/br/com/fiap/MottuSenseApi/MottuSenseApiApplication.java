package br.com.fiap.MottuSenseApi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info = @Info(title = "API do MottuSense", description = "Crud completo para clientes,motos,patio e sensores de localização", version = "v1"))
public class MottuSenseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MottuSenseApiApplication.class, args);
	}

}
