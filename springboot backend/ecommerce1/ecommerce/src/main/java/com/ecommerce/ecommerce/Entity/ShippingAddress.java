package com.ecommerce.ecommerce.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shipping_address")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "street",nullable = false)
    private String street;
    @Column(name = "city",nullable = false)
    private String city;
    @Column(name = "state",nullable = false)
    private String state;
    @Column(name = "country",nullable = false)
    private String country;
    @Column(name = "zip_code",nullable = false)
    private String zipCode;
    @OneToMany(mappedBy = "shipping_address")
    private List<Order> orderList;

    public ShippingAddress(String street, String city, String state, String country, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }
}
