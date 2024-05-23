package com.beiming.notebook.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.beiming.notebook.common.constant.Is;
import com.beiming.notebook.common.utils.RequestUtils;
import com.beiming.notebook.dao.mapper.NoteMapper;
import com.beiming.notebook.dao.mapper.NoteTagRelationMapper;
import com.beiming.notebook.dao.model.Note;
import com.beiming.notebook.dao.model.NoteTagRelation;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * NoteDAO
 */
@Repository
public class NoteDAO {

    @Resource
    private NoteMapper noteMapper;

    @Resource
    private NoteTagRelationMapper noteTagRelationMapper;

    public Long add(Note note) {
        note.setId(null);
        note.setUserId(RequestUtils.getCurrentUser().getId());
        noteMapper.insert(note);
        return note.getId();
    }

    public void updateContentById(Long id, String content) {
        noteMapper.update(
                new LambdaUpdateWrapper<Note>()
                        .eq(Note::getId, id)
                        .eq(Note::getIsDeleted, Is.NO)
                        .set(Note::getContent, content)
        );
    }

    public void togglePublic(Long id) {
        noteMapper.update(
                new LambdaUpdateWrapper<Note>()
                        .eq(Note::getId, id)
                        .eq(Note::getIsDeleted, Is.NO)
                        .setSql("is_public = if(is_public = 1, 0, 1)")
        );
    }

    public Page<Note> pageAllOrderDescId(int pageNum, int pageSize) {
        return noteMapper.selectPage(
                Page.of(pageNum, pageSize),
                new LambdaQueryWrapper<Note>()
                        .eq(Note::getIsDeleted, Is.NO)
                        .orderByDesc(Note::getId)
        );
    }

    public void linkTag(Long noteId, List<Long> tagIdList) {
        noteTagRelationMapper.delete(
                new LambdaQueryWrapper<NoteTagRelation>()
                        .eq(NoteTagRelation::getNoteId, noteId)
        );
        for (Long tagId : tagIdList) {
            NoteTagRelation noteTagRelation = new NoteTagRelation();
            noteTagRelation.setNoteId(noteId);
            noteTagRelation.setTagId(tagId);
            noteTagRelationMapper.insert(noteTagRelation);
        }
    }
}
