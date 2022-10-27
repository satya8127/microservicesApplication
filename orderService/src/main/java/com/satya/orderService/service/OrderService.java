package com.satya.orderService.service;

import com.satya.orderService.model.OrderRequest;
import org.springframework.stereotype.Service;


public interface OrderService {


     long placeOrder(OrderRequest orderRequest) ;

}
