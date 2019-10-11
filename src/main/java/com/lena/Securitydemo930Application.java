package com.lena;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan("com.lena.dao")
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启security注解
public class Securitydemo930Application {

	public static void main(String[] args) {
		SpringApplication.run(Securitydemo930Application.class, args);
	}

}
