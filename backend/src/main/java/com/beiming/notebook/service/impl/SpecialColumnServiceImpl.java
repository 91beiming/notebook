package com.beiming.notebook.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.beiming.notebook.controller.model.SpecialColumnParams;
import com.beiming.notebook.dao.SpecialColumnDAO;
import com.beiming.notebook.dao.model.SpecialColumn;
import com.beiming.notebook.service.SpecialColumnService;
import com.beiming.notebook.service.model.SpecialColumnDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * SpecialColumnServiceImpl
 */
@Service
public class SpecialColumnServiceImpl implements SpecialColumnService {

    @Resource
    private SpecialColumnDAO specialColumnDAO;


    @Override
    public void add(SpecialColumn specialColumn) {
        specialColumnDAO.add(specialColumn);
    }

    @Override
    public void updateName(Long id, String name) {
        specialColumnDAO.updateName(id, name);
    }

    @Override
    public IPage<SpecialColumnDTO> page(SpecialColumnParams params) {
        IPage<SpecialColumn> page = specialColumnDAO.page(params.getPageNum(), params.getPageSize());
        return page.convert(specialColumn -> specialColumn.clone(SpecialColumnDTO.class));
    }
}
