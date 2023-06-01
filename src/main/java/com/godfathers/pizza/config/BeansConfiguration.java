package com.godfathers.pizza.config;

import com.godfathers.pizza.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {
    @Bean("margherita")
    Pizza margherita() {
        return new Pizza("Margherita");
    }

    @Bean("hawaiian")
    Consumation hawaii() {
        return  new ExtraPizzaHamDecorator(new ExtraPizzaPineAppleDecorator( new Pizza("Hawaiian")));
    }

    @Bean("salami")
    Consumation salami() {
        return new ExtraPizzaSalamiDecorator( new Pizza("Salami"));
    }
    @Bean("familysizeextra")
    String familysizeextra() {
        return new ExtraPizzaFamilySizeDecorator().print();
    }
    @Bean("cheeseextra")
    String cheese() {
        return new ExtraPizzaCheeseDecorator().print();
    }
    @Bean("hamextra")
    String ham() {
        return new ExtraPizzaHamDecorator().print();
    }
    @Bean("onionsextra")
    String onions() {
        return new ExtraPizzaOnionsDecorator().print();
    }
    @Bean("pineappleextra")
    String pineapple() {
        return new ExtraPizzaPineAppleDecorator().print();
    }
    @Bean("salamiextra")
    String salamiextra() {
        return new ExtraPizzaSalamiDecorator().print();
    }
    @Bean("lemonade")
    Consumation lemonade() {
        return new Drink("Lemonade (0.33L)", 1.29,128.0 );
    }
    @Bean("water")
    Consumation water() {
        return new Drink("Water(0,5L)",1.29,0.0 );
    }
    @Bean("wine")
    Consumation wine() {
        return new Drink("Wine (0,75L, 13%",7.49,607.0 );
    }

    @Bean("shirts")
    Product shirts() {
        return new Merchandise("Shirt", 21.99) {
        };
    }
    @Bean("mug")
    Product mug() {
        return new Merchandise("Mug",4.99 );
    }

//    @Bean("table_1")
//    Table table_1() {
//        return new Table("1A",4);
//    }
//    @Bean("table_2")
//    Table table_2() {
//        return new Table("1B",6);
//    }
}
