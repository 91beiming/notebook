package com.beiming.notebook.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.beiming.notebook.controller.model.NoteParams;
import com.beiming.notebook.dao.model.Note;
import com.beiming.notebook.service.model.NoteDTO;

import java.util.List;

/**
 * NoteService
 */
public interface NoteService {
    void addNote(NoteParams params);

    void updateContentById(Note note);

    void togglePublic(Long id);

    IPage<NoteDTO> pageAll(NoteParams params);

    void linkTag(Long id, List<Long> tagIdList);
}
