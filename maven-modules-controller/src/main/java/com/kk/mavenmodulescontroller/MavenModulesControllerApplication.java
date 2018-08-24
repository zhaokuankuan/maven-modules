package com.kk.mavenmodulescontroller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.kk")
@ComponentScan("com.kk.*")
public class MavenModulesControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavenModulesControllerApplication.class, args);
	}
}
