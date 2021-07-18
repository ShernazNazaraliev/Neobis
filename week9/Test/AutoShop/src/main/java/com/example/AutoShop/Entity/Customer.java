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
@Entity (name = "customers")
public class Customer {
    @Id
    @SequenceGenerator(name = "Customer_seq", sequenceName = "Customer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customer_seq")
    @Column(name = "customer_ID")
    private Long customerID;

    private String customersName;
    private String email;
    private String adress;
    private String phoneNumber;

    public Customer(String customersName, String email, String adress, String phoneNumber) {
        this.customersName = customersName;
        this.email = email;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }
}
