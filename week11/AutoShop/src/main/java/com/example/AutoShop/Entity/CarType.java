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
@Entity (name = "carType")
@Table (name = "car_type")
public class CarType {

    @Id
    @SequenceGenerator(name = "car_type_seq",sequenceName = "car_type_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "car_type_seq")
    @Column(name = "car_type_ID")
    private Long typeID;

    private String carType;
}
