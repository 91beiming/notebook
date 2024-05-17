package com.beiming.notebook.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lcl
 * @date 2023/12/14 17:27
 */
@Setter
@Getter
public class BaseQuery extends BaseObject {

    private int pageNum = 1;
    private int pageSize = 10;

}
