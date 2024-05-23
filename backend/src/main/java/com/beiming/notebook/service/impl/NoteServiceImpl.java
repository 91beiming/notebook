package com.beiming.notebook.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.beiming.notebook.controller.model.NoteParams;
import com.beiming.notebook.dao.NoteDAO;
import com.beiming.notebook.dao.model.Note;
import com.beiming.notebook.service.CategoryService;
import com.beiming.notebook.service.NoteService;
import com.beiming.notebook.service.TagService;
import com.beiming.notebook.service.model.CategoryDTO;
import com.beiming.notebook.service.model.NoteDTO;
import com.beiming.notebook.service.model.TagDTO;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * NoteServiceImpl
 */
@Service
public class NoteServiceImpl implements NoteService {

    @Resource
    private NoteDAO noteDAO;

    @Resource
    private TagService tagService;

    @Resource
    private CategoryService categoryService;


    @Override
    public void addNote(NoteParams params) {
        Long noteId = noteDAO.add(params.clone(Note.class));
        if (ObjectUtils.isNotEmpty(params.getTagIdList())) {
            this.linkTag(noteId, params.getTagIdList());
        }
    }

    @Override
    public void updateContentById(Note note) {
        noteDAO.updateContentById(note.getId(), note.getContent());
    }

    @Override
    public void togglePublic(Long id) {
        noteDAO.togglePublic(id);
    }

    @Override
    public IPage<NoteDTO> pageAll(NoteParams params) {
        Page<Note> notePage = noteDAO.pageAllOrderDescId(params.getPageNum(), params.getPageSize());
        IPage<NoteDTO> noteDTOIPage = notePage.convert(note -> note.clone(NoteDTO.class));
        for (NoteDTO noteDTO : noteDTOIPage.getRecords()) {
            fillTagAndCategory(noteDTO);
        }
        return noteDTOIPage;
    }

    @Override
    public void linkTag(Long id, List<Long> tagIdList) {
        noteDAO.linkTag(id, tagIdList);
    }

    /**
     * 填充标签和分类信息
     */
    private void fillTagAndCategory(NoteDTO noteDTO) {
        //标签
        List<TagDTO> tagDTOList = tagService.getByNoteId(noteDTO.getId());
        noteDTO.setTagList(tagDTOList);
        //分类
        CategoryDTO categoryDTO = categoryService.getById(noteDTO.getCategoryId());
        noteDTO.setCategory(categoryDTO);
    }
}
