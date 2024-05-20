package com.beiming.notebook.service;

import com.beiming.notebook.controller.model.TagParams;
import com.beiming.notebook.dao.model.Tag;
import com.beiming.notebook.service.model.TagDTO;

import java.util.List;

/**
 * TagService
 */
public interface TagService {

    void add(Tag tag);

    void update(Tag tag);

    void deleteById(Long id);

    List<TagDTO> likeByName(TagParams params);

}
