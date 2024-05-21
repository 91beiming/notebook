package com.beiming.notebook.dao;

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
}
