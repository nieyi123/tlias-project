package com.yjj.Interceptor;

import com.yjj.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 登录校验拦截器
 */
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1. 获取请求头中的令牌（token）
        String jwt = request.getHeader("token");

        //2. 判断令牌是否存在，如果不存在，返回错误结果（未登录）
        if(!StringUtils.hasLength(jwt)){ 
            log.info("令牌为空, 返回未登录信息");
            response.setStatus(401); // 401 Unauthorized
            return false;
        }

        //3. 解析token，如果解析失败，返回错误结果（未登录）
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            log.info("令牌解析失败, 返回未登录信息");
            response.setStatus(401); // 401 Unauthorized
            return false;
        }

        //4. 放行
        log.info("令牌合法, 放行");
        return true;
    }

}