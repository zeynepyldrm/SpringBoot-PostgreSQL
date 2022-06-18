package com.example.dto;

import com.example.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private Long id;
    private String categoryName;
   private List<String> products;
}
