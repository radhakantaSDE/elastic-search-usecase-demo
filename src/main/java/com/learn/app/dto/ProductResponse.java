package com.learn.app.dto;

import com.learn.app.model.Product;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class ProductResponse implements Serializable {

    private List<Product> products;
}
