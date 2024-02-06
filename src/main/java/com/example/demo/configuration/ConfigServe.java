package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigServe {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Applique CORS à toutes les routes
                        .allowedOrigins("http://localhost:8080") // Autorise le front-end
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Méthodes autorisées
                        .allowedHeaders("*") // En-têtes autorisés
                        .allowCredentials(true);
            }
        };
    }
}
