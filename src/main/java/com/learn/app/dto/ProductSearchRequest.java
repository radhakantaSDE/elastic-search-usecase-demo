package com.learn.app.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ProductSearchRequest implements Serializable {

    private String columnName;
    private String searchText;
}
