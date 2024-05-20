package com.beiming.notebook.module.tag;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.beiming.notebook.module.tag.model.Tag;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TagDAO
 */
@Repository
public class TagDAO {

    @Resource
    private TagMapper tagMapper;

    public void add(Tag tag) {
        tagMapper.insert(tag);
    }

    public void update(Tag tag) {
        tagMapper.updateById(tag);
    }

    public void deleteById(Long id) {
        tagMapper.deleteById(id);
    }

    public List<Tag> likeByName(String name) {
        return tagMapper.selectList(
                new LambdaQueryWrapper<Tag>()
                        .like(StringUtils.isNotBlank(name), Tag::getName, name)
        );
    }
}
