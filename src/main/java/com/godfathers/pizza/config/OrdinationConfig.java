package com.godfathers.pizza.config;

import com.godfathers.pizza.entities.Order;
import com.godfathers.pizza.entities.Ordination;
import com.godfathers.pizza.entities.Table;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:application.properties")
public class OrdinationConfig {
    @Bean("table")
    @Scope("prototype")
    Table table(){
        return new Table();
    }
    @Bean("table_A1")
    Table tableA1(){
        return new Table("A1",4);
    }
    @Bean("table_A2")
    Table tableA2(){
        return new Table("A2",6);
    }
    @Bean("ordinantion")
    @Scope("prototype")
    Ordination ordination(){
        return new Ordination();
    }
    @Bean("order")
    @Scope("prototype")
    Order order(){
        return new Order();
    }

}
