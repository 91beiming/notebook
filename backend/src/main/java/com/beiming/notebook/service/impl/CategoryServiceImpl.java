package com.beiming.notebook.service.impl;

import com.beiming.notebook.common.utils.BeanCopyUtils;
import com.beiming.notebook.dao.CategoryDAO;
import com.beiming.notebook.dao.model.Category;
import com.beiming.notebook.service.CategoryService;
import com.beiming.notebook.service.model.CategoryDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CategoryServiceImpl
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryDAO categoryDAO;

    @Override
    public void add(Category category) {
        categoryDAO.add(category);
    }

    @Override
    public void updateById(Category category) {
        categoryDAO.updateById(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryDAO.deleteById(id);
    }

    @Override
    public List<CategoryDTO> likeByName(String name) {
        List<Category> list = categoryDAO.likeByName(name);
        return BeanCopyUtils.copyList(list, CategoryDTO.class);
    }

    @Override
    public CategoryDTO getById(Long categoryId) {
        Category category = categoryDAO.getById(categoryId);
        if (category != null) {
            return category.clone(CategoryDTO.class);
        }
        return null;
    }
}
