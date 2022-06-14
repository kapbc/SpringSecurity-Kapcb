package com.kapcb.security.helloworld.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

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
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/loginSystem")
                .successForwardUrl("/index")
                .failureUrl("/login.html")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
                .csrf().disable().build();
    }

}
