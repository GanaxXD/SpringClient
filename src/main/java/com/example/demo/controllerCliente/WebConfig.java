package com.example.demo.controllerCliente;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	/*
	 * Essa classe fará o Cross-Origin permitido para qualquer requisição.
	 * Ela vai permitir que todos os métodos da aplicação sejam acessados
	 * independente da origem (local) da requisição.
	 */
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//Por padrão, o Spring nega requisições do tipo Option, por isso, é preferível 
		//adicionar logo todos os métodos, como no exemplo ativo:
		//registry.addMapping("/**");
		
		registry.addMapping("/**")
			.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT")
			.allowedOrigins("*");
	}
}
