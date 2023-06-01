package com.godfathers.pizza.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
@Entity
public class ExtraPizzaFamilySizeDecorator extends ExtraPizzaDecorator{
    public ExtraPizzaFamilySizeDecorator(){
        super("Family Size",4.15, 1.95);

    }
    public ExtraPizzaFamilySizeDecorator(Consumation pizza){
        super("Family Size",4.15, 1.95);
        this.decoratedPizza = pizza;
    }
    @Override
    public Double getCalories() {
        return decoratedPizza.getCalories() * this.calories;
    }
    public String print() {
        return "{" +
                "name=Extra Family Size"  +
                ", calories= x" + this.calories +
                ", price= +" + this.price +
                '}';
    }

}
