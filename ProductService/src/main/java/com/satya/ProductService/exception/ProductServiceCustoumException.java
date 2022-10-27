package com.satya.ProductService.exception;

import lombok.Data;

@Data
public class ProductServiceCustoumException extends RuntimeException {
    private  String errorCode;
    public ProductServiceCustoumException(String message,String errorCode){
        //Super(message);
        super(message);
        this.errorCode=errorCode;
    }
}
