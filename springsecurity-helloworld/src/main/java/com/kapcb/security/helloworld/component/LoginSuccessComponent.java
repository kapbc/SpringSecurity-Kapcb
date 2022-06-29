package com.kapcb.security.helloworld.component;

import org.springframework.stereotype.Component;

/**
 * <a>Title: LoginSuccessComponent </a>
 * <a>Author: cb <a>
 * <a>Description: LoginSuccessComponent <a>
 *
 * @author cb
 * @version 1.0
 * @date 2022/6/29 22:35
 * @since 1.0
 */
@Component
public class LoginSuccessComponent {

    public String processSuccess() {
        return "login success!";
    }

}
