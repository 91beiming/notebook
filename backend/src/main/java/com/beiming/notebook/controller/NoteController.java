package com.beiming.notebook.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.beiming.notebook.controller.model.NoteParams;
import com.beiming.notebook.dao.model.Note;
import com.beiming.notebook.service.NoteService;
import com.beiming.notebook.service.model.NoteDTO;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * NoteController
 * 笔记
 */
@RestController
@RequestMapping("note")
public class NoteController {

    @Resource
    private NoteService noteService;

    /**
     * 添加笔记
     */
    @PostMapping("add")
    public Boolean addNote(@RequestBody NoteParams params) {
        noteService.addNote(params);
        return true;
    }

    /**
     * 关联标签
     */
    @PostMapping("linkTag")
    public Boolean linkTag(@RequestBody @Validated(NoteParams.linkTag.class) NoteParams params) {
        noteService.linkTag(params.getId(), params.getTagIdList());
        return true;
    }

    /**
     * 更新笔记内容
     */
    @PostMapping("updateContentById")
    public Boolean updateContentById(@RequestBody @Validated(NoteParams.updateContentById.class) NoteParams params) {
        noteService.updateContentById(params.clone(Note.class));
        return true;
    }

    /**
     * 切换笔记是否公开
     */
    @PostMapping("togglePublic")
    public Boolean togglePublic(@RequestBody @Validated(NoteParams.togglePublic.class) NoteParams params) {
        noteService.togglePublic(params.getId());
        return true;
    }

    /**
     * 所有笔记分页查询,
     * 根据笔记ID,从大到小
     */
    @GetMapping("pageAll")
    public IPage<NoteDTO> pageAll(NoteParams params) {
        return noteService.pageAll(params);
    }

}
