package com.beiming.notebook.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.beiming.notebook.controller.model.SpecialColumnParams;
import com.beiming.notebook.dao.model.SpecialColumn;
import com.beiming.notebook.service.SpecialColumnService;
import com.beiming.notebook.service.model.SpecialColumnDTO;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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

    /**
     * 修改专栏名称
     */
    @PostMapping("updateName")
    public Boolean updateName(@RequestBody @Validated(SpecialColumnParams.updateName.class) SpecialColumnParams params) {
        specialColumnService.updateName(params.getId(), params.getName());
        return true;
    }

    /**
     * 分页查询专栏
     */
    @GetMapping("page")
    public IPage<SpecialColumnDTO> page(SpecialColumnParams params) {
        return specialColumnService.page(params);
    }
}
