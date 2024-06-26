package com.beiming.notebook.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.beiming.notebook.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * UserMapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}