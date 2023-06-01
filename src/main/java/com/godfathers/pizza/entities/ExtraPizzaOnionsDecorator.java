package com.godfathers.pizza.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
@Entity
public class ExtraPizzaOnionsDecorator extends ExtraPizzaDecorator{
    public ExtraPizzaOnionsDecorator(){
        super("Onions",0.69, 22.0);
    }
    public ExtraPizzaOnionsDecorator(Consumation pizza){
        super("Onions",0.69, 22.0);
        this.decoratedPizza = pizza;
    }
}
