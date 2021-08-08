package com.example.AutoShop.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "price_list")
public class PriceList {
    @Id
    @SequenceGenerator(name = "price_list_seq",
            sequenceName = "price_list_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "price_list_seq")
    @Column (name = "price_id")
    private Long priceID;

    @Column (name = "price")
    private double price;
}
