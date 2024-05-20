package com.beiming.notebook.controller;

import com.beiming.notebook.controller.model.TagParams;
import com.beiming.notebook.dao.model.Tag;
import com.beiming.notebook.service.TagService;
import com.beiming.notebook.service.model.TagDTO;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TagController
 * 标签
 */
@RestController
@RequestMapping("tag")
public class TagController {
    @Resource
    private TagService tagService;


    /**
     * 增
     */
    @PostMapping("add")
    public Boolean addTag(@RequestBody TagParams params) {
        Tag tag = params.clone(Tag.class);
        tagService.add(tag);
        return true;
    }

    /**
     * 改
     */
    @PostMapping("update")
    public Boolean updateTag(@RequestBody @Validated(TagParams.updateTag.class) TagParams params) {
        Tag tag = params.clone(Tag.class);
        tagService.update(tag);
        return true;
    }

    /**
     * 删
     */
    @PostMapping("deleteById")
    public Boolean deleteById(@RequestBody @Validated(TagParams.deleteById.class) TagParams params) {
        tagService.deleteById(params.getId());
        return true;
    }

    /**
     * 查
     * 根据名称模糊查询
     */
    @GetMapping("likeByName")
    public List<TagDTO> likeByName(TagParams params) {
        return tagService.likeByName(params);
    }

    /**
     * 树形标签
     */
    @GetMapping("tagTree")
    public List<TagDTO> tagTree() {
        return tagService.tagTree();
    }
}
