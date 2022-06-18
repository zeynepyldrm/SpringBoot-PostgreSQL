package com.example.service.Impl;

import com.example.dto.CategoryDto;
import com.example.model.Category;
import com.example.model.Product;
import com.example.repository.CategoryRepository;
import com.example.repository.ProductRepository;
import com.example.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public CategoryDto save(CategoryDto categoryDto) {
        Category category = new Category();
        category.setCategoryName(categoryDto.getCategoryName());
        final Category categoryDB = categoryRepository.save(category);
        List<Product> productList = new ArrayList<>();

        categoryDto.getProducts().forEach(item -> {
            Product product = new Product();
            product.setProductName(item);
            product.setType(Product.ProductType.SOLID);
            product.setDeleted(false);
            product.setCategory(categoryDB);
            productList.add(product);
        });
        productRepository.saveAll(productList);
        categoryDto.setId(categoryDB.getId());
        return categoryDto;
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();

        categories.forEach(item -> {
            CategoryDto dto = new CategoryDto();
            dto.setId(item.getId());
            dto.setCategoryName(item.getCategoryName());
            dto.setProducts(item.getProducts().stream().map(Product::getProductName).collect(Collectors.toList()));
            categoryDtos.add(dto);
        });
        return  categoryDtos;
    }
    @Override
    public CategoryDto getById(Long id) {
        Optional<Category> optional=categoryRepository.findById(id);
        CategoryDto dto=new CategoryDto();
        if(optional.isPresent()){
            List<String>products=new ArrayList<>();
            Category cat=optional.get();
            dto.setId(cat.getId());
            dto.setCategoryName(cat.getCategoryName());
            cat.getProducts().forEach(item-> products.add(item.getProductName()));
            dto.setProducts(products);
        }
        else{
            throw new RuntimeException("Category not exist by id");
        }
        return  dto;
    }

    @Override
    public Page<CategoryDto> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public HttpStatus deleteCategory(Long id) {
        try {
            categoryRepository.deleteById(id);
            return HttpStatus.valueOf(200);
        }
        catch (Exception ex){
            return HttpStatus.valueOf(500);
        }
    }

}
