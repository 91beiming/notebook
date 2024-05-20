package com.beiming.notebook.controller;

import com.beiming.notebook.controller.model.CategoryParams;
import com.beiming.notebook.dao.model.Category;
import com.beiming.notebook.service.CategoryService;
import com.beiming.notebook.service.model.CategoryDTO;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CategoryController
 * 分类模块
 */
@RestController
@RequestMapping("category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 添加分类
     */
    @PostMapping("add")
    public Boolean add(@RequestBody CategoryParams params) {
        categoryService.add(params.clone(Category.class));
        return true;
    }

    /**
     * 修改
     */
    @PostMapping("updateById")
    public Boolean updateById(@RequestBody @Validated(CategoryParams.updateById.class) CategoryParams params) {
        categoryService.updateById(params.clone(Category.class));
        return true;
    }

    /**
     * 删除
     */
    @PostMapping("deleteById")
    public Boolean deleteById(@RequestBody @Validated(CategoryParams.deleteById.class) CategoryParams params) {
        categoryService.deleteById(params.getId());
        return true;
    }

    /**
     * 根据名称模糊查询
     */
    @GetMapping("likeByName")
    public List<CategoryDTO> likeByName(CategoryParams params) {
        return categoryService.likeByName(params.getName());
    }
}
