package com.beiming.notebook.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.beiming.notebook.dao.model.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TagMapper
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {
    List<Tag> selectTagByNoteId(@Param("noteId") Long noteId);
}