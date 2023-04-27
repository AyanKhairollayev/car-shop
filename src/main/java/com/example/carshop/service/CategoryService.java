package com.example.carshop.service;

import com.example.carshop.controller.dto.CategoryDto;
import com.example.carshop.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory() throws Exception;
    Category getById(Long id) throws Exception;
    Category createCateegory(CategoryDto categoryDto) throws Exception;
    Category updateCategory(Long id,CategoryDto categoryDto) throws Exception;
    void deleteCategory(Long id);

}
