package com.example.AutoShop.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "cars")
@Table (name = "cars")
public class Car {
    @Id
    @SequenceGenerator(name = "cars_seq", sequenceName = "cars_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cars_seq")
    @Column (name = "car_Id")
    private Long CarId;

    private String carName;

    private String color;

    @ManyToOne
    @JoinColumn (name = "car_type_ID", referencedColumnName = "car_type_ID")
    private CarType carType;

    @ManyToOne
    @JoinColumn(name = "price_ID",referencedColumnName = "price_ID")
    private PriceList priceID;

}
