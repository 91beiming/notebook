package com.beiming.notebook.common.entity;


import com.beiming.notebook.common.utils.BeanCopyUtils;

/**
 * BaseObject
 */
public class BaseObject {

    public <T> T clone(Class<T> tClass) {
        T t = BeanCopyUtils.copyProperties(this, tClass);
        return t;
    }
}
