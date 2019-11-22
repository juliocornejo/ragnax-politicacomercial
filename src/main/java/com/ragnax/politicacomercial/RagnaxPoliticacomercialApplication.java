package com.ragnax.politicacomercial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.ragnax.politicacomercial.configuration.FactoryApiProperties;

@SpringBootApplication
@EnableConfigurationProperties(FactoryApiProperties.class)
public class RagnaxPoliticacomercialApplication {

	public static void main(String[] args) {
		SpringApplication.run(RagnaxPoliticacomercialApplication.class, args);
	}

}
