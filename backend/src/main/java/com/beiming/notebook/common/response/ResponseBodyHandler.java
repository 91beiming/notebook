package com.beiming.notebook.common.response;

import com.beiming.notebook.common.utils.JsonUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

@ControllerAdvice(basePackages = "com.beiming")
public class ResponseBodyHandler implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        Optional<Method> methodOptional = Optional.ofNullable(returnType.getMethod());
        if (methodOptional.isEmpty()) {
            return false;
        }
        Class<?> returnClass = methodOptional.get().getReturnType();
        return R.class != returnClass;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof String) {
            response.getHeaders().put(HttpHeaders.CONTENT_TYPE, List.of(MediaType.APPLICATION_JSON_VALUE));
            return JsonUtils.toJson(R.ok(body));
        }
        if (body instanceof R) {
            return body;
        }
        return R.ok(body);
    }
}