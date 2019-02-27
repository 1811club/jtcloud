package com.student.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.student.sso.mapper")
public class SsoStarter {
	
	public static void main(String[] args) {
		SpringApplication.run(SsoStarter.class, args);
	}

}
