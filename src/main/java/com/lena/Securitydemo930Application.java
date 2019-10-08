package com.lena;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lena.dao")
public class Securitydemo930Application {

	public static void main(String[] args) {
		SpringApplication.run(Securitydemo930Application.class, args);
	}

}
