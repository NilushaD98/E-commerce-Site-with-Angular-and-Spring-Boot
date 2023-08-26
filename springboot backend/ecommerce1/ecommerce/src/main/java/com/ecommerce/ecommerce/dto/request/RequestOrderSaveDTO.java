package com.ecommerce.ecommerce.dto.request;

import com.ecommerce.ecommerce.Entity.BillingAddress;
import com.ecommerce.ecommerce.Entity.Customer;
import com.ecommerce.ecommerce.Entity.OrderItem;
import com.ecommerce.ecommerce.Entity.ShippingAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSaveDTO {

    private int totalQuantity;
    private BigDecimal totalPrice;
    private RequestShippingAddressSaveDTO shipping_address;
    private RequestBillingAddressSaveDTO billing_address;
    private RequestCustomerSaveDTO customer;
    private ArrayList<RequestOrderItemSaveDTO> orderItemSaveDTOList;
}
