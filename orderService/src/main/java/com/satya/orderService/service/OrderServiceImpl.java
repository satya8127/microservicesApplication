package com.satya.orderService.service;

import com.satya.orderService.entity.Order;
import com.satya.orderService.model.OrderRequest;
import com.satya.orderService.repository.OrderRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{
 private OrderRepo orderRepo;

    @Override
    public long placeOrder(OrderRequest orderRequest) {
        log.info("placing the order",orderRequest);
        Order order= Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("created")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();
        order=orderRepo.save(order);
        log.info("order placed sucessfully",order.getId());
        return order.getId();
    }
}
