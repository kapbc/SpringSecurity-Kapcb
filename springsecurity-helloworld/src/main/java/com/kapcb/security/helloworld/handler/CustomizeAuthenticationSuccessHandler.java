package com.kapcb.security.helloworld.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: CustomizeAuthenticationSuccessHandler </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CustomizeAuthenticationSuccessHandler <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/6/16 23:47
 * @since 1.0
 */
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        Map<String, Object> resultMap = new HashMap<>(4);
        resultMap.put("code", 200);
        resultMap.put("msg", null);
        resultMap.put("data", "1111111");
        String jsonResult = JSON.toJSONString(resultMap);
        response.getWriter().write(jsonResult);
        response.getWriter().close();
    }

}
