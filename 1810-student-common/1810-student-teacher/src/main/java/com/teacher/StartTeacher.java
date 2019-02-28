package com.teacher;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.teacher.mapper")
public class StartTeacher {
	
	public static void main(String[] args) {
		SpringApplication.run(StartTeacher.class, args);
	}

}
