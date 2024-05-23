package com.beiming.notebook.service.impl;

import com.beiming.notebook.common.utils.BeanCopyUtils;
import com.beiming.notebook.controller.model.TagParams;
import com.beiming.notebook.dao.TagDAO;
import com.beiming.notebook.dao.model.Tag;
import com.beiming.notebook.service.TagService;
import com.beiming.notebook.service.model.TagDTO;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<TagDTO> tagTree() {
        //获取所有标签
        List<Tag> allTags = tagDAO.list();
        //转成DTO
        List<TagDTO> allTagDTOs = BeanCopyUtils.copyList(allTags, TagDTO.class);
        //根节点列表
        List<TagDTO> rootList = new ArrayList<>();
        Map<Long, List<TagDTO>> mappingMap = new HashMap<>();
        for (TagDTO tagDTO : allTagDTOs) {
            if (ObjectUtils.isEmpty(tagDTO.getPid())) {
                //根节点
                rootList.add(tagDTO);
            } else {
                //子节点,放入key为父节点的list中
                mappingMap.computeIfAbsent(tagDTO.getPid(), k -> new ArrayList<>()).add(tagDTO);
            }
            tagDTO.setChildren(mappingMap.computeIfAbsent(tagDTO.getId(), k -> new ArrayList<>()));
        }
        return rootList;
    }

    @Override
    public List<TagDTO> getByNoteId(Long noteId) {
        List<Tag> tagList = tagDAO.getByNoteId(noteId);
        return BeanCopyUtils.copyList(tagList, TagDTO.class);
    }
}
