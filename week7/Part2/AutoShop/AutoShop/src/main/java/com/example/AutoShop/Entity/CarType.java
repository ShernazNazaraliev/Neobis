package com.example.AutoShop.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "car_type")
public class CarType {

    @Id
    @SequenceGenerator(name = "car_type_seq", sequenceName = "car_type_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_type_seq")
    @Column(name = "car_type_id")
    private Long id;

    @Column(name = "car_type")
    private String carType;
}
