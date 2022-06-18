package com.example.service;

import com.example.dto.CategoryDto;
import com.example.model.Category;
import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);
    List<CategoryDto> getAll();
    CategoryDto getById(Long id);
    Page<CategoryDto> getAll(Pageable pageable);
    HttpStatus deleteCategory(Long id);
}
