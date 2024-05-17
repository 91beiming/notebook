package com.beiming.notebook.common.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.springframework.cglib.beans.BeanCopier;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lcl
 * @date 2023/9/11 17:05
 * @desc BeanCopyUtil
 */
@UtilityClass
public class BeanCopyUtils {

    private static final Map<String, BeanCopier> beanCopierCache = new HashMap<>();

    public static <S, T> T copyProperties(S s, T t) {
        String cacheKey = s.getClass().getName() + "_" + t.getClass().getName();
        BeanCopier beanCopier = beanCopierCache.get(cacheKey);
        if (null == beanCopier) {
            synchronized (BeanCopyUtils.class) {
                beanCopier = beanCopierCache.get(cacheKey);
                if (null == beanCopier) {
                    beanCopier = BeanCopier.create(s.getClass(), t.getClass(), false);
                    beanCopierCache.put(cacheKey, beanCopier);
                }
            }
        }
        beanCopier.copy(s, t, null);
        return t;
    }

    @SneakyThrows
    public static <S, T> T copyProperties(S s, Class<T> tClass) {
        if (null == s) {
            return null;
        }
        Constructor<T> noArgsConstructor = tClass.getDeclaredConstructor();
        noArgsConstructor.setAccessible(true);
        return copyProperties(s, noArgsConstructor.newInstance());
    }

    public static <S, T> List<T> copyList(List<S> sourceList, Class<T> tClass) {
        if (null != sourceList) {
            List<T> list = new ArrayList<>(sourceList.size());
            for (S s : sourceList) {
                list.add(copyProperties(s, tClass));
            }
            return list;
        } else {
            return Collections.emptyList();
        }
    }
}
