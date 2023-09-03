package com.learningmanager.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.learningmanager.*.mapper")
public class LearningmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningmanagerApplication.class, args);
	}

}
