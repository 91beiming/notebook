package com.beiming.notebook.service.impl;

import com.beiming.notebook.dao.SpecialColumnDAO;
import com.beiming.notebook.dao.model.SpecialColumn;
import com.beiming.notebook.service.SpecialColumnService;
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
}
