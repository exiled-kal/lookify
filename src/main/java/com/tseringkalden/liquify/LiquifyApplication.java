package com.tseringkalden.liquify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@ComponentScan(basePackages={"com.tseringkalden"})
@SpringBootApplication
public class LiquifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiquifyApplication.class, args);
	}

}
