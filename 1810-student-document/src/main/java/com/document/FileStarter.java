package com.document;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.document.mapper")
public class FileStarter {
			public static void main(String[] args) {
					SpringApplication.run(FileStarter.class, args);
			}
}
