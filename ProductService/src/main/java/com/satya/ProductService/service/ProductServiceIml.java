package com.satya.ProductService.service;

import com.satya.ProductService.entity.Product;
import com.satya.ProductService.exception.ProductServiceCustoumException;
import com.satya.ProductService.model.ProductRequest;
import com.satya.ProductService.model.ProductResponse;
import com.satya.ProductService.repository.ProductRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceIml implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Override
    public long addProduct(ProductRequest productRequest) {

        Product product=Product.builder().productName(productRequest.getName()).quantity(productRequest.getQuantity())
                .price(productRequest.getPrice()).build();
         productRepo.save(product);
         return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        Product product=  productRepo.findById(productId)
                .orElseThrow(() ->new ProductServiceCustoumException("product with given id not found","PRODUCT_NOT_FOUND"));
        ProductResponse productResponse=new ProductResponse();
        BeanUtils.copyProperties(product,productResponse);
                return productResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("reduce quantity{} for Id:{}",quantity,productId);
        Product product= productRepo.findById(productId).orElseThrow(()-> new ProductServiceCustoumException("product with give id not found","PRODUCT_NOT_FOUND"));
      if(product.getQuantity()<quantity){
          throw new ProductServiceCustoumException("product does not have sufficient quantity","INSUFFICIENT_QUANTITY");
      }
      product.setQuantity(product.getQuantity()-quantity);

      productRepo.save(product);
    }
}
