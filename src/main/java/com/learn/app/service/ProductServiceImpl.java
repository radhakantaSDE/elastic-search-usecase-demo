package com.learn.app.service;

import com.learn.app.dto.ProductSearchRequest;
import com.learn.app.model.Product;
import com.learn.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    /**
     * Helps to save the product in elasticsearch
     * @param product Product document for save
     * */
    @Override
    public String saveProduct(Product product) {
        Product newProduct = productRepository.save(product);
        return newProduct.getId() != null ? "Product saved successfully :)" : "Failed to save the product :(";
    }

    /**
     * Helps to retrieve all products
     * */
    @Override
    public List<Product> getAllProducts() {

        List<Product> result = new ArrayList<>();
        productRepository.findAll().forEach(result::add);
        return result;
    }

    /**
     * ElasticSearch demo for extensive search operations :
     * 1. CriteriaQuery
     * 2. StringQuery
     * 3. NativeQuery
     * As per search request search response will return result
     * */
    @Override
    public List<Product> searchProduct(ProductSearchRequest searchRequest) {

        if (searchRequest.getColumnName() != null) {
            Criteria criteria = Criteria.where(searchRequest.getColumnName()).contains(searchRequest.getSearchText());
            CriteriaQuery criteriaQuery = CriteriaQuery.builder(criteria).build();
            return elasticsearchOperations.search(criteriaQuery, Product.class).stream().map(SearchHit::getContent).toList();
        }
        return List.of();
    }
}
