package com.learn.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.io.Serializable;

@Data
@Document(indexName = "products")
@Setting(settingPath = "config/search-config.json")
public class Product implements Serializable {

    @Id
    private String id;
    private String name;
    private String description;
    private Float price;

    @Field(type = FieldType.Text, analyzer = "autocomplete_index", searchAnalyzer = "autocomplete_search")
    private String category;
    private String brand;

}
