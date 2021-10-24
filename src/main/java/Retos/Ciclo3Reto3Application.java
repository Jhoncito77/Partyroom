package Retos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"Retos.Modelo"})

public class Ciclo3Reto3Application {

	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Reto3Application.class, args);
	}

}
