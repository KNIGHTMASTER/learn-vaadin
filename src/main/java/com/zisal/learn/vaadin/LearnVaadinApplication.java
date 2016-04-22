package com.zisal.learn.vaadin;

import com.vaadin.spring.annotation.EnableVaadin;
import com.zisal.learn.vaadin.constant.ApplicationConstant.Configuration.SpringConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(SpringConfiguration.COMPONENT_SCAN)
@SpringBootApplication
@EnableVaadin
public class LearnVaadinApplication extends ServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LearnVaadinApplication.class, args);
	}
}
