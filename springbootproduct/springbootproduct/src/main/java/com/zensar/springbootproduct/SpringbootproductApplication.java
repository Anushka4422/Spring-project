package com.zensar.springbootproduct;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "test", "com.zensar" })
public class SpringbootproductApplication {
	public static void main(String... args) {
		System.out.println("Anushka");
		SpringApplication.run(SpringbootproductApplication.class, args);
		System.out.println("sita");
	}

	@Bean
	public ModelMapper getmodelMapper() {
		return new ModelMapper();
	}
}
