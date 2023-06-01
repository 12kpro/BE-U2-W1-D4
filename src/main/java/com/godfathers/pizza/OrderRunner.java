package com.godfathers.pizza;

import com.godfathers.pizza.config.OrdinationConfig;
import com.godfathers.pizza.entities.*;
import com.godfathers.pizza.utils.OrderState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class OrderRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(OrdinationConfig.class);
        AnnotationConfigApplicationContext ctp = new AnnotationConfigApplicationContext(PizzaApplication.class);

        List<Ordination> ordinations = new ArrayList<>();

// Esperimento funziona
//        List<Table> tables = new ArrayList<>();
//        tables.add((Table) ctx.getBean("table"));
//        tables.get(0).setRef("A1");
//        tables.get(0).setSeats(4);
//        tables.add((Table) ctx.getBean("table"));
//        tables.get(1).setRef("A2");
//        tables.get(1).setSeats(5);
//         tables.forEach(table -> log.info(table.toString()));

        //************** ordinazione 1 *************//
        ordinations.add((Ordination) ctx.getBean("ordinantion"));
        ordinations.get(0).setConsumation((Consumation) ctp.getBean("margherita"));
        ordinations.get(0).setQty(1);
        ordinations.get(0).setNote("Riccardo odia la pizza con l'ananas!!");
        //************** ordinazione 2 *************//
        ordinations.add((Ordination) ctx.getBean("ordinantion"));
        ordinations.get(1).setConsumation((Consumation) ctp.getBean("lemonade"));
        ordinations.get(1).setQty(1);
        //************** ordinazione 3 *************//
        ordinations.add((Ordination) ctx.getBean("ordinantion"));
        ordinations.get(2).setConsumation((Consumation) ctp.getBean("salami"));
        ordinations.get(2).setQty(2);
        //************** ordinazione 4 *************//
        ordinations.add((Ordination) ctx.getBean("ordinantion"));
        ordinations.get(3).setConsumation((Consumation) ctp.getBean("wine"));
        ordinations.get(3).setQty(2);


        ordinations.forEach(ordination -> log.info(ordination.toString()));

        Table t1 = (Table) ctx.getBean("table_A1");
        t1.setOccupiedPlaces(3);
        t1.setFree(false);

        Order o1 = (Order) ctx.getBean("order");
        o1.setState(OrderState.INCORSO);
        o1.setItems(ordinations);
        o1.setTableRef(t1);
        o1.orderTotal();
        log.info(o1.toString());
        ctx.close();
    }
}
