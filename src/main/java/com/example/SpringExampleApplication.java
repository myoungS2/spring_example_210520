package com.example;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@MapperScan(basePackages = "com.example.*")  // mapper scan 추가!!!

// @ComponentScan(basePackages={"com", "com.example","com.myoung"})
// @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) => DB연동해야하기 때문에 주석처리!
@SpringBootApplication
public class SpringExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
	}
	/*
	 * @ComponentScan(basePackages={"com", "com.example", ...etc}) => basePackage가 아닌 패키지에 spring bean을 사용하고 싶을 때 쓰는 어노테이션 
	 *    ㄴ component
	 * */
	
	@Bean // 스프링객체
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
        sessionFactory.setMapperLocations(res);

        return sessionFactory.getObject();
    }
}
