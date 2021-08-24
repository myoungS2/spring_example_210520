package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
// @ComponentScan(basePackages={"com", "com.example","com.myoung"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class SpringExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
	}
	/*
	 * @ComponentScan(basePackages={"com", "com.example", ...etc}) => basepackage가 아닌 패키지에 spring bean을 사용하고 싶을 때 쓰는 어노테이션 
	 *    ㄴ component
	 * */
}
