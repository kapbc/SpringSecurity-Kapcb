package com.kapcb.security.helloworld.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * <a>Title: UserController </a>
 * <a>Author: cb <a>
 * <a>Description: UserController <a>
 *
 * @author cb
 * @version 1.0
 * @date 2022/7/3 15:31
 * @since 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("user-info")
    public String userInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Object credentials = authentication.getCredentials();
        Object principal = authentication.getPrincipal();
        System.out.println("name : " + name + "'s credentials is : " + credentials + " principal is : " + principal + " authorities is : " + authorities);
        return name;
    }

    @GetMapping("sub-thread-user-info")
    public void subThreadUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Object credentials = authentication.getCredentials();
        Object principal = authentication.getPrincipal();
        System.out.println("name : " + name + "'s credentials is : " + credentials + " principal is : " + principal + " authorities is : " + authorities);

        new Thread(() -> {
            Authentication subThreadAuthentication = SecurityContextHolder.getContext().getAuthentication();
            if (subThreadAuthentication == null) {
                System.out.println("Thread : " + Thread.currentThread().getName() + " get SecurityContext fail!");
                return;
            }
            String subThreadName = subThreadAuthentication.getName();
            System.out.println("thread : " + Thread.currentThread().getName() + " get user info : " + subThreadName);
        }, "A").start();
    }

}
