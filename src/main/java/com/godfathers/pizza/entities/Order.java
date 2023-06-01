package com.godfathers.pizza.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.godfathers.pizza.utils.OrderState;

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
//@Entity
//@jakarta.persistence.Table(name="orders")
//@PropertySource("classpath:application.properties")
public class Order {
	@Id
	private UUID id = UUID.randomUUID();
	private Double totalPrice;
	private OrderState state;
	private LocalDateTime dateTime = LocalDateTime.now();
	private List<Ordination> items;
//	@ManyToOne
//	@JoinColumn(name = "table_ref_id")
	private Table tableRef;
	@Value("${seatprice}")
	String seatPrice;

	public Order(OrderState state, List<Ordination> items, Table tableRef) {
		this.state = state;
		this.items = items;
		this.tableRef = tableRef;
	}

	// @PostConstruct
	public void orderTotal() {
		//log.info(this.seatPrice);
		Double seatsPrice = this.tableRef.getSeats() * Double.parseDouble(this.seatPrice);

		double totalAmount = 0;
		for (Ordination ordination : this.items) {
			totalAmount += ordination.getTotalValue();
		}

		this.totalPrice = seatsPrice + totalAmount;
	}
}
