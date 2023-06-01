package com.godfathers.pizza.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Setter
@Getter
@Slf4j
@Entity
@Table(name="drinks")
@NoArgsConstructor
public class Drink extends  Consumation{

    public Drink(String name, Double price, Double calories) {
        super(name, price, calories);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "calories=" + calories +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
