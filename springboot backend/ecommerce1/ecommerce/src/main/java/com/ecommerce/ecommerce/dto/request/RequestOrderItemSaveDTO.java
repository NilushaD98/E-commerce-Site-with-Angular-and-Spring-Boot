package com.ecommerce.ecommerce.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderItemSaveDTO {
    private Long id;
    private String imageURL;
    private BigDecimal unitPrice;
    private int quantity;
}
