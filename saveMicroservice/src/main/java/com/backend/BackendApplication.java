package com.backend;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE")
						.allowedHeaders("*");
			}
		};
	}
	/*
	 * @Bean Queue queue() { return new Queue("spring-boot", false); }
	 * 
	 * @Bean TopicExchange exchange() { return new
	 * TopicExchange("spring-boot-exchange"); }
	 * 
	 * @Bean Binding binding(Queue queue, TopicExchange exchange) { return
	 * BindingBuilder.bind(queue).to(exchange).with("foo.bar.#"); }
	 * 
	 * @Bean SimpleMessageListenerContainer container(ConnectionFactory
	 * connectionFactory) { SimpleMessageListenerContainer container = new
	 * SimpleMessageListenerContainer();
	 * container.setConnectionFactory(connectionFactory);
	 * container.setQueueNames("spring-boot"); return container; }
	 */
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
