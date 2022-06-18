package com.kapcb.security.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <a>Title: RouterController </a>
 * <a>Author: Kapcb <a>
 * <a>Description: RouterController <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/6/17 23:32
 * @since 1.0
 */
@Controller
@RequestMapping("/router")
public class RouterController {

    @RequestMapping("loginTemplate")
    public String loginTemplate() {
        return "loginTmeplate";
    }
}
