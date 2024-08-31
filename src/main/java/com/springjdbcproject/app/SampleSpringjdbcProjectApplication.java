package com.springjdbcproject.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SampleSpringjdbcProjectApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SampleSpringjdbcProjectApplication.class, args);
		ProjectExecution projectExecution = applicationContext.getBean(ProjectExecution.class);
		projectExecution.init();
	}

}
