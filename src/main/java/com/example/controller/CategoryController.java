package com.example.controller;

import com.example.dto.CategoryDto;
import com.example.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
}
