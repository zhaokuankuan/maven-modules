package com.kk.mavenmodulescontroller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.kk.maven.modules.dao.*")
@ComponentScan(basePackages = {"com.kk.*","com.kk.maven.modules.config","com.kk.maven.modules.common"})
public class MavenModulesControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavenModulesControllerApplication.class, args);
	}

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}
}
