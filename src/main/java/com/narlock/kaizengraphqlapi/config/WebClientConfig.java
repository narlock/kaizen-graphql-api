package com.narlock.kaizengraphqlapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

  @Bean
  public WebClient profileWebClient() {
    return WebClient.builder().baseUrl("http://localhost:8079/profile").build();
  }
}
