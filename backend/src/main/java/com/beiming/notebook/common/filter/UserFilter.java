package com.beiming.notebook.common.filter;

import com.beiming.notebook.common.constant.HttpAttributeKey;
import com.beiming.notebook.common.constant.HttpHeaderKey;
import com.beiming.notebook.common.constant.Is;
import com.beiming.notebook.common.constant.LuaScripts;
import com.beiming.notebook.common.constant.RedisKey;
import com.beiming.notebook.common.constant.UserRedisConstant;
import com.beiming.notebook.common.exception.NotLoginException;
import com.beiming.notebook.common.response.R;
import com.beiming.notebook.common.utils.JsonUtils;
import com.beiming.notebook.domain.UserDTO;
import jakarta.annotation.Resource;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * UserFilter
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 2)
public class UserFilter implements Filter {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 白名单,直接放行
     */
    private final List<String> whiteList = new ArrayList<>();


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        whiteList.add("/login/**");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        for (String url : whiteList) {
            if (antPathMatcher.match(url, requestURI)) {
                //白名单直接放行
                request.setAttribute(HttpAttributeKey.ALLOW_KEY, Is.YES);
                try {
                    filterChain.doFilter(servletRequest, servletResponse);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                String uuid = request.getHeader(HttpHeaderKey.AUTHORIZATION);
                if (StringUtils.isNotBlank(uuid)) {
                    String userJsonStr = stringRedisTemplate.execute(LuaScripts.GET_USER,
                            List.of(RedisKey.USER_UUID_KEY + uuid),
                            UserRedisConstant.EXPIRE_TIME.toString());
                    if (StringUtils.isNotBlank(userJsonStr)) {
                        UserDTO userDTO = JsonUtils.toObject(userJsonStr, UserDTO.class);
                        //用户已登陆
                        request.setAttribute(HttpAttributeKey.USER_KEY, userDTO);
                        filterChain.doFilter(servletRequest, servletResponse);
                        return;
                    }
                }
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(JsonUtils.toJson(
                        R.error(new NotLoginException("访问该资源需要登陆"))
                ));
            }
        }
    }
}
