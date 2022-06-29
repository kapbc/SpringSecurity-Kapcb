package com.kapcb.security.helloworld.controller;

import com.kapcb.security.helloworld.component.LoginSuccessComponent;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <a>Title: HelloWorldController </a>
 * <a>Author: Kapcb <a>
 * <a>Description: HelloWorldController <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/6/12 22:05
 * @since 1.0
 */
@RestController
public class HelloWorldController {

    private final LoginSuccessComponent loginSuccessComponent;

    public HelloWorldController(ObjectProvider<LoginSuccessComponent> loginSuccessComponentObjectProvider) {
        loginSuccessComponent = loginSuccessComponentObjectProvider.stream().findFirst().orElseThrow(RuntimeException::new);
    }

    @GetMapping("index")
    public String index() {
        return loginSuccessComponent.processSuccess();
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("loginFail")
    public String loginFail() {
        return "Sorry, Login Fail";
    }

}
