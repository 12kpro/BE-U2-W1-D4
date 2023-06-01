package com.godfathers.pizza.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
//@Entity
//@Table(name="ordinations")
public class Ordination {
    @Id
    private UUID id = UUID.randomUUID();
    private Consumation consumation;
    private int qty = 1;
    private String note;

    public Ordination(Consumation consumation, String note)
    {
        this.setConsumation(consumation);
        this.setNote(note);
    }
    public Ordination(Consumation consumation, String note, int qty)
    {
        this.setConsumation(consumation);
        this.setQty(qty);
        this.setNote(note);
    }



    public double getTotalValue() {
        return consumation.getPrice() * qty;
    }
}
