package com.ecommerce.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE,reason = "Order Item List is Empty")
public class OrderListEmptyException extends RuntimeException{
}
