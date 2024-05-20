package com.beiming.notebook.common.utils;

import com.beiming.notebook.common.constant.HttpAttributeKey;
import com.beiming.notebook.common.exception.CustomerException;
import com.beiming.notebook.common.exception.NotLoginException;
import com.beiming.notebook.service.model.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

/**
 * RequestUtils
 */
public class RequestUtils {

    public static UserDTO getCurrentUser() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return Optional.ofNullable(requestAttributes)
                .map(attr -> (ServletRequestAttributes) attr)
                .map(ServletRequestAttributes::getRequest)
                .map(request -> request.getAttribute(HttpAttributeKey.USER_KEY))
                .map(o -> (UserDTO) o)
                .orElseThrow(() -> new NotLoginException("用户信息获取错误"));
    }

    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return Optional.ofNullable(requestAttributes)
                .map(attr -> (ServletRequestAttributes) attr)
                .map(ServletRequestAttributes::getRequest)
                .orElseThrow(() -> new CustomerException("获取请求信息错误"));
    }

}
