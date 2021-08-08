package com.example.AutoShop.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @SequenceGenerator(name = "cars_seq", sequenceName = "cars_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cars_seq")
    @Column(name = "car_id")
    private Long id;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "car_color")
    private String color;

    @ManyToOne
    @JoinColumn(name = "car_type_id", referencedColumnName = "car_type_id")
    private CarType carTypeId;

    @ManyToOne
    @JoinColumn(name = "price_id", referencedColumnName = "price_id")
    private PriceList priceListId;
}
