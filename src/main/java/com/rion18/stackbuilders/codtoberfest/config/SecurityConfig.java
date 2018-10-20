package com.rion18.stackbuilders.codtoberfest.config;

import com.rion18.stackbuilders.codtoberfest.security.DisableCorsConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig {

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new DisableCorsConfig();
  }

}
