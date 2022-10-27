package com.satya.ProductService.service;

import com.satya.ProductService.model.ProductRequest;
import com.satya.ProductService.model.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);
}
