package com.beiming.notebook.dao;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.beiming.notebook.dao.mapper.SpecialColumnMapper;
import com.beiming.notebook.dao.model.SpecialColumn;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * SpecialColumnDAO
 */
@Repository
public class SpecialColumnDAO {

    @Resource
    private SpecialColumnMapper specialColumnMapper;

    public void add(SpecialColumn specialColumn) {
        specialColumnMapper.insert(specialColumn);
    }

    public void updateName(Long id, String name) {
        specialColumnMapper.update(
                new LambdaUpdateWrapper<SpecialColumn>()
                        .eq(SpecialColumn::getId, id)
                        .set(SpecialColumn::getName, name)
        );
    }

    public IPage<SpecialColumn> page(int pageNum, int pageSize) {
        return specialColumnMapper.selectPage(Page.of(pageNum, pageSize), null);
    }
}
