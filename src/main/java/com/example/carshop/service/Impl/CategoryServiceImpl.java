package com.example.carshop.service.Impl;

import com.example.carshop.controller.dto.CategoryDto;
import com.example.carshop.model.Category;
import com.example.carshop.repository.CategoryRepository;
import com.example.carshop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category createCateegory(CategoryDto categoryDto) throws Exception {
        Category category = new Category();
        category.setName(categoryDto.getName());
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id,CategoryDto categoryDto) throws Exception {
        Category category = categoryRepository.findById(id).orElseThrow();
        if(id != null){
            category.setName(categoryDto.getName());
        }
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getAllCategory() throws Exception {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Long id) throws Exception {
        return categoryRepository.findById(id).orElseThrow();
    }
}
