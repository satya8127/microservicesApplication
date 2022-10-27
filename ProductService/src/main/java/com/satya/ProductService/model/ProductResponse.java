package com.satya.ProductService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@AllArgsConstructor
@Builder
public class ProductResponse {
    private String productName;
    private long productId;
    private long quantity;
    private long price;
}
