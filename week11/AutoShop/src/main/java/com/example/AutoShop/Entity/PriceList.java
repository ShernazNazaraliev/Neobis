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
@Entity (name = "priceList")
@Table (name = "price_list")
public class PriceList {

    @Id
    @SequenceGenerator(name = "price_list_seq",sequenceName = "price_list_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "price_list_seq")
    @Column(name = "price_ID")
    private Long priceID;

    private double price;
}
