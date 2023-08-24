package com.ecommerce.ecommerce.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "order_trcking_number",nullable = false)
    private String orderTrackingNumber;
    @Column(name = "total_quantity",nullable = false)
    private int totalQuantity;
    @Column(name = "total_price",nullable = false)
    private BigDecimal totalPrice;
    @ManyToOne
    @JoinColumn(name = "shipping_address",nullable = false)
    private ShippingAddress shipping_address;
    @ManyToOne
    @JoinColumn(name = "billing_address",nullable = false)
    private BillingAddress billing_address;
    @Column(name = "status",nullable = false)
    private boolean status;
    @Column(name = "date_created",nullable = false)
    private Date dateCreated;
    @Column(name = "last_updated",nullable = false)
    private Date lastUpdated;
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItemList;

}
