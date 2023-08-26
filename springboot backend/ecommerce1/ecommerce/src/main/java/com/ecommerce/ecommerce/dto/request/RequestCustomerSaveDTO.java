package com.ecommerce.ecommerce.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestCustomerSaveDTO {
    private String firstName;
    private String lastName;
    private String email;
}
