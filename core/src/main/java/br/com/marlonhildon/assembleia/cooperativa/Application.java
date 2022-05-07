package br.com.marlonhildon.assembleia.cooperativa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mustache.MustacheAutoConfiguration;

/**
 * Classe de inicialização. A exclusão foi realizada para evitar a busca de templates pelo Mustache.
 */
@SpringBootApplication(exclude = {MustacheAutoConfiguration.class})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
