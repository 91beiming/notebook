package com.beiming.notebook.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.beiming.notebook.dao.model.Note;
import org.apache.ibatis.annotations.Mapper;

/**
 * NoteMapper
 */
@Mapper
public interface NoteMapper extends BaseMapper<Note> {
}