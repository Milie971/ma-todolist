package com.todo.backend; // même package que les autres classes

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration // Indique que c’est une classe de configuration
public class WebConfig {

  @Bean // Cette méthode produit une "configuration" utilisable par Spring
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // On applique la règle à toutes les routes commençant par /api/
                .allowedOrigins("*")   // * = on autorise toutes les origines (pratique en dev)
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // Méthodes HTTP autorisées
      }
    };
  }
}