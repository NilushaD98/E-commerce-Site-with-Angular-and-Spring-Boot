package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.dto.request.RequestOrderSaveDTO;
import com.ecommerce.ecommerce.service.OrderService;
import com.ecommerce.ecommerce.util.StandardResponse;
import com.sun.xml.bind.api.impl.NameConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/order/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(
            value = {"order_save"}
    )
    public ResponseEntity<StandardResponse> orderSave(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO){
        System.out.println(requestOrderSaveDTO);
        String orderSaveStatus  = orderService.saveOrder(requestOrderSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Order Save Status: ",orderSaveStatus,0), HttpStatus.OK
        );
    }
}
