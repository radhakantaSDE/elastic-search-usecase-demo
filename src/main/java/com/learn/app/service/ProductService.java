package com.learn.app.service;

import com.learn.app.dto.ProductSearchRequest;
import com.learn.app.model.Product;

import java.util.List;

public interface ProductService {

    String saveProduct(Product product);
    List<Product> getAllProducts();

    // Product Search operations
    List<Product> searchProduct(ProductSearchRequest searchRequest);

}
