package com.example.AutoShop.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "Car")
@Table (name = "Cars")
public class Car {
    @Id
    @SequenceGenerator(name = "Customer_seq", sequenceName = "Customer_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customer_seq")
    @Column (name = "car_Id")
    private Long CarId;

    private String carName;

    private String color;

    @ManyToOne
    @JoinColumn (name = "car_Type_ID", referencedColumnName = "car_Type_ID")
    private CarType carType;

    @ManyToOne
    @JoinColumn(name = "price_ID",referencedColumnName = "price_ID")
    private PriceList priceID;

}
