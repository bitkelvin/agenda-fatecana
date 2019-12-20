package com.fatecsp.agendafatecana.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {
  
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String environment;

    @Getter
    @Setter
    private List<String> servers = new ArrayList<>();
 
    // standard getters and setters
 
}