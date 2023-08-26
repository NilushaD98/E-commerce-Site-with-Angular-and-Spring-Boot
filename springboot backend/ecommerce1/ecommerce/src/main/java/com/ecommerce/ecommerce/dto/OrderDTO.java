package com.ecommerce.ecommerce.dto;

import com.ecommerce.ecommerce.Entity.BillingAddress;
import com.ecommerce.ecommerce.Entity.Customer;
import com.ecommerce.ecommerce.Entity.OrderItem;
import com.ecommerce.ecommerce.Entity.ShippingAddress;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderDTO {

    private Long id;
    private String orderTrackingNumber;
    private int totalQuantity;
    private BigDecimal totalPrice;
    private ShippingAddress shipping_address;
    private BillingAddress billing_address;
    private boolean status;
    private Date dateCreated;
    private Date lastUpdated;
    private Customer customer;

}
