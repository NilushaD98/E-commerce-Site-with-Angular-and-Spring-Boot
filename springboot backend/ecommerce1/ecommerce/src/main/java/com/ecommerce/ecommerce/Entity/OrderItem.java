package com.ecommerce.ecommerce.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "image_url",nullable = false)
    private String imageURL;
    @Column(name = "unit_price",nullable = false)
    private BigDecimal unitPrice;
    @Column(name = "quantity",nullable = false)
    private int Quantity;
    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;
    @OneToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
}
