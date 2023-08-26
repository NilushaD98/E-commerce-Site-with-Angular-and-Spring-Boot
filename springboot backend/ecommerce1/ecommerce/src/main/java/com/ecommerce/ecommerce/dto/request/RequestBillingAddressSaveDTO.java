package com.ecommerce.ecommerce.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestBilllingAddressSaveDTO {
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
