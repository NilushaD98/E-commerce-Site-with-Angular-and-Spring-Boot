package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.dto.request.RequestOrderSaveDTO;

public interface OrderService {
    String saveOrder(RequestOrderSaveDTO requestOrderSaveDTO);
}
