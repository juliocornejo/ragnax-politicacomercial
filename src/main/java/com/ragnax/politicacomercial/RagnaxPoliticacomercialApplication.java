package com.ragnax.politicacomercial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.ragnax.politicacomercial.configuration.FactoryApiProperties;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties(FactoryApiProperties.class)
public class RagnaxPoliticacomercialApplication {

	public static void main(String[] args) {
		SpringApplication.run(RagnaxPoliticacomercialApplication.class, args);
	}

}
