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
@Entity (name = "PriceList")
@Table (name = "PriceList")
public class PriceList {

    @Id
    @SequenceGenerator(name = "PriceList_seq",sequenceName = "PriceList_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PriceList_seq")
    @Column(name = "price_ID")
    private Long priceID;

    private double price;
}
