package com.godfathers.pizza.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Setter
@Getter
@Slf4j
@ToString
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Product {
    @Id
    private UUID id = UUID.randomUUID();
    String name;
    Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
