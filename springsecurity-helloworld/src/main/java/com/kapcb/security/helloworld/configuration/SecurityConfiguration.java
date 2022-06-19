package com.kapcb.security.helloworld.configuration;

import com.alibaba.fastjson.JSON;
import com.kapcb.security.helloworld.handler.CustomizeAuthenticationFailureHandler;
import com.kapcb.security.helloworld.handler.CustomizeAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

import java.util.HashMap;
import java.util.Map;

/**
 * <a>Title: SecurityConfiguration </a>
 * <a>Author: Kapcb <a>
 * <a>Description: SecurityConfiguration <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/6/13 22:23
 * @since 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests()
                .antMatchers("/loginFail")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/router/loginTemplate")
                .loginProcessingUrl("/loginSystem")
                .successHandler(customizeSuccessHandler())
                .failureHandler(customizeFailureHandler())
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new OrRequestMatcher(
                        new AntPathRequestMatcher("/logout1", HttpMethod.GET.name()),
                        new AntPathRequestMatcher("/logout2", HttpMethod.POST.name())
                ))
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .defaultLogoutSuccessHandlerFor((request, response, auth) -> {
                    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                    Map<String, Object> resultMap = new HashMap<>(4);
                    resultMap.put("code", 200);
                    resultMap.put("msg", "logout1 success!");
                    resultMap.put("data", null);
                    String jsonResult = JSON.toJSONString(resultMap);
                    response.getWriter().write(jsonResult);
                    response.getWriter().close();
                }, new AntPathRequestMatcher("/logout1", HttpMethod.GET.name()))
                .defaultLogoutSuccessHandlerFor((request, response, auth) -> {
                    response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
                    Map<String, Object> resultMap = new HashMap<>(4);
                    resultMap.put("code", 200);
                    resultMap.put("msg", "logout2 success!");
                    resultMap.put("data", null);
                    String jsonResult = JSON.toJSONString(resultMap);
                    response.getWriter().write(jsonResult);
                    response.getWriter().close();
                }, new AntPathRequestMatcher("/logout2", HttpMethod.POST.name()))
                .and()
                .csrf().disable().build();
    }

    protected SavedRequestAwareAuthenticationSuccessHandler successHandler() {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setDefaultTargetUrl("/index");
        successHandler.setTargetUrlParameter("target");
        return successHandler;
    }

    protected CustomizeAuthenticationSuccessHandler customizeSuccessHandler() {
        return new CustomizeAuthenticationSuccessHandler();
    }

    protected SimpleUrlAuthenticationFailureHandler failureHandler() {
        SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();
        failureHandler.setDefaultFailureUrl("/loginFail");
        failureHandler.setUseForward(true);
        return failureHandler;
    }

    protected CustomizeAuthenticationFailureHandler customizeFailureHandler() {
        return new CustomizeAuthenticationFailureHandler();
    }

}
