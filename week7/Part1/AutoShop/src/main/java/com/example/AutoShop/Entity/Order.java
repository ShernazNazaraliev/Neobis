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
@Entity (name = "Orders")
@Table (name = "Orders")
public class Order {

    @Id
    @SequenceGenerator(name = "Order_seq", sequenceName = "Order_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Order_seq")
    @Column (name = "order_ID")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customer_ID", referencedColumnName = "customer_ID")
    private Customer customerID;

    @ManyToOne
    @JoinColumn(name = "car_ID", referencedColumnName = "car_ID")
    private Car carID;
}
