package com.ecommerce.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShippingAddressDTO{
        private Long id;
        private String street;
        private String city;
        private String state;
        private String country;
        private String zipCode;
}
