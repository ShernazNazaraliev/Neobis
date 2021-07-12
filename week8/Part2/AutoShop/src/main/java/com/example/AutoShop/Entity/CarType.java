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
@Entity (name = "CarType")
@Table (name = "Car_Type")
public class CarType {

    @Id
    @SequenceGenerator(name = "CarType_seq",sequenceName = "CarType_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CarType_seq")
    @Column(name = "car_Type_ID")
    private Long typeID;

    private String carType;
}
