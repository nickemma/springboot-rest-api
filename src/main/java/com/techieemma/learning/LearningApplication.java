package com.techieemma.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearningApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(LearningApplication.class, args);

		MyFirstClass myFirstClass = ctx.getBean(MyFirstClass.class);
		System.out.println(myFirstClass.Greeting());
	}

	@Bean
	public MyFirstClass myFirstClass() {
		return new MyFirstClass();
	}

}
