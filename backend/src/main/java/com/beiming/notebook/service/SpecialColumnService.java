package com.beiming.notebook.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.beiming.notebook.controller.model.SpecialColumnParams;
import com.beiming.notebook.dao.model.SpecialColumn;
import com.beiming.notebook.service.model.SpecialColumnDTO;

/**
 * SpecialColumnService
 */
public interface SpecialColumnService {
    void add(SpecialColumn specialColumn);

    void updateName(Long id, String name);

    IPage<SpecialColumnDTO> page(SpecialColumnParams params);
}
