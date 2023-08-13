package com.ecommerce.ecommerce.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id",nullable = false,length = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productID;
    @Column(name = "sku",nullable = false)
    private String sku;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;
    @Column(name = "image_url",nullable = false)
    private String imageURL;
    @Column(name = "active",nullable = false)
    private boolean activeStatus;
    @Column(name = "units_in_stock",nullable = false,length = 11)
    private int unitInStock;
    @Column(name = "date_created",nullable = false)
    @CreationTimestamp
    private Date dateCreated;
    @Column(name = "last_updated",nullable = false)
    @UpdateTimestamp
    private Date lastUpdate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",nullable = false)// Add this annotation to break the circular reference
    private ProductCategory category;

    public Product(String sku, String name, String description, BigDecimal unitPrice, String imageURL, boolean activeStatus, int unitInStock, Date dateCreated, Date lastUpdate, ProductCategory category) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.imageURL = imageURL;
        this.activeStatus = activeStatus;
        this.unitInStock = unitInStock;
        this.dateCreated = dateCreated;
        this.lastUpdate = lastUpdate;
        this.category = category;
    }
}
