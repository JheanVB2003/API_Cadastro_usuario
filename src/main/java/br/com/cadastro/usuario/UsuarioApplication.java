package br.com.cadastro.usuario;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API de Usuários", version = "1", description = "API de cadastros de usuários"))
public class UsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioApplication.class, args);
	}

}
