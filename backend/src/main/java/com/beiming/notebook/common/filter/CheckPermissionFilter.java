package com.beiming.notebook.common.filter;

import com.beiming.notebook.common.constant.HttpAttributeKey;
import com.beiming.notebook.common.constant.Is;
import com.beiming.notebook.common.exception.NotPermissionException;
import com.beiming.notebook.common.response.R;
import com.beiming.notebook.common.utils.JsonUtils;
import com.beiming.notebook.service.model.UserDTO;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * CheckPermissionFilter
 * 需要是管理员才能访问的
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 3)
public class CheckPermissionFilter implements Filter {

    /**
     * 黑名单权限列表,需要有管理员权限才能访问
     */
    private final Set<String> permissions = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        permissions.add("/xxx");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Object allow = request.getAttribute(HttpAttributeKey.ALLOW_KEY);
        if (Is.YES.equals(allow)) {
            //白名单直接放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            UserDTO userDTO = (UserDTO) request.getAttribute(HttpAttributeKey.USER_KEY);
            //是管理员
            if (Is.YES.equals(userDTO.getIsAdmin())) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
            //检测是否在权限列表中
            if (!permissions.contains(request.getRequestURI())) {
                //不在,放行
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                //在
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(JsonUtils.toJson(
                        R.error(new NotPermissionException("无权限访问,请联系管理员"))
                ));
            }
        }
    }
}
