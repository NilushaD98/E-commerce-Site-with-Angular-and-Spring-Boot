package com.ecommerce.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {

    private Long productID;
    private String sku;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private String imageURL;
    private boolean activeStatus;
    private int unitInStock;
    private Date dateCreated;
    private Date lastUpdate;
    private Long category;

}
