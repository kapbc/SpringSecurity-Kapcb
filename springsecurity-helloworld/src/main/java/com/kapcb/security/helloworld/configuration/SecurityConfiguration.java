package com.kapcb.security.helloworld.configuration;

import com.kapcb.security.helloworld.handler.CustomizeAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

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
                .failureForwardUrl("/router/loginTemplate")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
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

}
