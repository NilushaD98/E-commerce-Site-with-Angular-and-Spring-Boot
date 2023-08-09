package com.ecommerce.ecommerce.dto;

import com.ecommerce.ecommerce.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCategoryDTO {

    private Long productCategoryID;
    private String categoryName;

}
