package com.godfathers.pizza.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
@ToString
@NoArgsConstructor
@Entity
public abstract class Consumation extends Product{
    protected Double calories;
    public Consumation(String name, Double price, Double calories) {
        super(name, price);
        this.calories = calories;
    }
}
