package com.beiming.notebook.controller;

import com.beiming.notebook.controller.model.SpecialColumnParams;
import com.beiming.notebook.dao.model.SpecialColumn;
import com.beiming.notebook.service.SpecialColumnService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpecialColumnController
 */
@RestController
@RequestMapping("specialColumn")
public class SpecialColumnController {

    @Resource
    private SpecialColumnService specialColumnService;

    /**
     * 添加专栏
     */
    @PostMapping("add")
    public Boolean addSpecialColumn(@RequestBody SpecialColumnParams params) {
        specialColumnService.add(params.clone(SpecialColumn.class));
        return true;
    }

}
