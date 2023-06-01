package com.godfathers.pizza.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
@NoArgsConstructor
@Table(name="toppings")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class ExtraPizzaDecorator extends Consumation {
    @Transient
    protected Consumation decoratedPizza;

    public ExtraPizzaDecorator(String name, Double price, Double calories) {
        super(name, price, calories);
    }


    public String getName() {
        return decoratedPizza.getName()+ " con extra " + this.name;
    }

    public Double getPrice() {
        return decoratedPizza.getPrice() + this.price;
    }

    public Double getCalories() {
        return decoratedPizza.getCalories() + this.calories;
    }
    public String print() {
        return "{" +
                "name=Extra " + this.name  +
                ", calories= +" + this.calories +
                ", price= +" + this.price +
                '}';
    }

    public String toString() {
        return "{" +
                "calories=" + this.getCalories() +
                ", name='" + this.getName() + '\'' +
                ", price=" + this.getPrice() +
                '}';
    }
}
