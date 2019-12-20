package com.fatecsp.agendafatecana;

import com.fatecsp.agendafatecana.config.YAMLConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgendaFatecanaApplication implements CommandLineRunner{

	@Autowired
    private YAMLConfig myConfig;

	public static void main(String[] args) {
		SpringApplication.run(AgendaFatecanaApplication.class, args);
	}

	public void run(String... args) throws Exception {
        System.out.println("name: " + myConfig.getName());
        System.out.println("servers: " + myConfig.getServers());
    }

}
