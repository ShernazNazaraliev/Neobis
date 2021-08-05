package com.example.AutoShop.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "orders")
@Table (name = "orders")
public class Order {

    @Id
    @SequenceGenerator(name = "orders_seq", sequenceName = "orders_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq")
    @Column (name = "order_ID")
    private Long orderID;

    @ManyToOne
    @JoinColumn(name = "customer_ID", referencedColumnName = "customer_ID")
    private Customer customerID;

    @ManyToOne
    @JoinColumn(name = "car_ID", referencedColumnName = "car_ID")
    private Car carID;
}
