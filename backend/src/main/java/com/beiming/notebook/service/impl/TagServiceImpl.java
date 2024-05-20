package com.beiming.notebook.service.impl;

import com.beiming.notebook.common.utils.BeanCopyUtils;
import com.beiming.notebook.controller.model.TagParams;
import com.beiming.notebook.dao.TagDAO;
import com.beiming.notebook.dao.model.Tag;
import com.beiming.notebook.service.TagService;
import com.beiming.notebook.service.model.TagDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TagServiceImpl
 */
@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagDAO tagDAO;

    public void add(Tag tag) {
        tagDAO.add(tag);
    }

    public void update(Tag tag) {
        tagDAO.update(tag);
    }

    public void deleteById(Long id) {
        tagDAO.deleteById(id);
    }

    public List<TagDTO> likeByName(TagParams params) {
        List<Tag> list = tagDAO.likeByName(params.getName());
        return BeanCopyUtils.copyList(list, TagDTO.class);
    }
}
