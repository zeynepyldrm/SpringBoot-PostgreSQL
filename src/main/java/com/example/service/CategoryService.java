package com.example.service;

import com.example.dto.CategoryDto;
import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);
    List<CategoryDto> getAll();
    Page<CategoryDto> getAll(Pageable pageable);
}
