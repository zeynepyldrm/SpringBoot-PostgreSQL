package com.example.controller;

import com.example.interceptors.HeaderInterceptor;
import com.example.dto.CategoryDto;
import com.example.model.Category;
import com.example.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping
    public ResponseEntity<CategoryDto> save(@Validated  @RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.save(categoryDto));
    }
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllList(){
        return  ResponseEntity.ok(categoryService.getAll());
    }
    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable(name = "id") Long id){
        return categoryService.getById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable(value = "id") Long id,@Validated @RequestBody CategoryDto categoryDto){
         Category updated= categoryService.updateCategory(id,categoryDto);
         return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable(name = "id") Long id){
        categoryService.deleteCategory(id);
    }
}
