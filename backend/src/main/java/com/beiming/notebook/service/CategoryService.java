package com.beiming.notebook.service;

import com.beiming.notebook.dao.model.Category;
import com.beiming.notebook.service.model.CategoryDTO;

import java.util.List;

/**
 * CategoryService
 */
public interface CategoryService {

    void add(Category category);

    void updateById(Category category);

    void deleteById(Long id);

    List<CategoryDTO> likeByName(String name);

    CategoryDTO getById(Long categoryId);
}
