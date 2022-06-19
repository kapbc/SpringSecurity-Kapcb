package com.kapcb.security.helloworld.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: CustomizeAuthenticationFailureHandler </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CustomizeAuthenticationFailureHandler <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/6/19 11:14
 * @since 1.0
 */
public class CustomizeAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        Map<String, Object> resultMap = new HashMap<>(4);
        resultMap.put("code", 500);
        resultMap.put("msg", exception.getMessage());
        resultMap.put("data", null);
        String jsonResult = JSON.toJSONString(resultMap);
        response.getWriter().write(jsonResult);
        response.getWriter().close();
    }

}
