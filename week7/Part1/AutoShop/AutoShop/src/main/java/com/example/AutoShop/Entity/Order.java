package com.example.AutoShop.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @SequenceGenerator(name = "orders_seq", sequenceName = "orders_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq")
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    private Car carId;

    @Column(name = "status")
    private String status;

    @Column(name = "date_of_creation")
    private LocalDateTime actionDate;

    public Order(Customer customerId, Car carId, String status) {
        this.customerId = customerId;
        this.carId = carId;
        this.status = status;
    }
}
