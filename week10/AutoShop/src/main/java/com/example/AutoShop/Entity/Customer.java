package com.example.AutoShop.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @SequenceGenerator(name = "customers_seq", sequenceName = "customers_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_seq")
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String email;

    @Column(name = "customer_address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;
}
