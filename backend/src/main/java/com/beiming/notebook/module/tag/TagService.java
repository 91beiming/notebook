package com.beiming.notebook.module.tag;

import com.beiming.notebook.common.utils.BeanCopyUtils;
import com.beiming.notebook.module.tag.model.Tag;
import com.beiming.notebook.module.tag.model.TagDTO;
import com.beiming.notebook.module.tag.model.TagParams;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TagService
 */
@Repository
public class TagService {

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
