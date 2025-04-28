package br.com.fiap.MottuSenseApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MottuSenseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MottuSenseApiApplication.class, args);
	}

}
