package com.learn.app.controller;

import com.learn.app.dto.ProductResponse;
import com.learn.app.dto.ProductSearchRequest;
import com.learn.app.model.Product;
import com.learn.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Save a document to elasticsearch
     * @param product Product document which want to save
     * */
    @PostMapping
    public ResponseEntity<String> saveProduct(@RequestBody Product product) {

        return ResponseEntity.ok(productService.saveProduct(product));
    }

    /**
     * Retrieve all the products of logged-in (Hypothetical use-case) users
     * */
    @GetMapping("all")
    public ResponseEntity<ProductResponse> getAllProducts(){

        return ResponseEntity.ok(ProductResponse.builder().products(productService.getAllProducts()).build());
    }

    /**
     * Search products on different column names
     * @param searchRequest Search criteria for searching products
     * */
    @PostMapping("search")
    public ResponseEntity<ProductResponse> searchProducts(@RequestBody ProductSearchRequest searchRequest){

        return ResponseEntity.ok(ProductResponse.builder().products(productService.searchProduct(searchRequest)).build());
    }


}
