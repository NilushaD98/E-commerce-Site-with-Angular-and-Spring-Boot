package com.ecommerce.ecommerce.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product_category")
public class ProductCategory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productCategoryID;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category",fetch = FetchType.LAZY)
    @JsonIgnoreProperties("category")
    private Set<Product> productSet= new HashSet<>();

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }
}