package com.godfathers.pizza;

import com.godfathers.pizza.entities.Pizza;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@Slf4j
public class PizzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);

	}

}
