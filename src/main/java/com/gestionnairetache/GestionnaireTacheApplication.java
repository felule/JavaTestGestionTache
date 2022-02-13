package com.gestionnairetache;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Tache API", version = "2.0", description = "Tache Information"))
public class GestionnaireTacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionnaireTacheApplication.class, args);
	}

}
