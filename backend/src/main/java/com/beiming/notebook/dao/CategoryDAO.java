package com.beiming.notebook.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.beiming.notebook.dao.mapper.CategoryMapper;
import com.beiming.notebook.dao.model.Category;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CategoryDAO
 */
@Repository
public class CategoryDAO {

    @Resource
    private CategoryMapper categoryMapper;

    public void add(Category category) {
        categoryMapper.insert(category);
    }

    public void updateById(Category category) {
        categoryMapper.updateById(category);
    }

    public void deleteById(Long id) {
        categoryMapper.deleteById(id);
    }

    public List<Category> likeByName(String name) {
        return categoryMapper.selectList(
                new LambdaQueryWrapper<Category>()
                        .like(StringUtils.isNotBlank(name), Category::getName, name)
        );
    }

    public Category getById(Long categoryId) {
        return categoryMapper.selectById(categoryId);
    }
}
