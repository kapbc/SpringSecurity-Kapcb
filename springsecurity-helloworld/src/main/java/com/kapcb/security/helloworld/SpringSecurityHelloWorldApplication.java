package com.kapcb.security.helloworld;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <a>Title: SpringSecurityHelloWorldApplication </a>
 * <a>Author: Kapcb <a>
 * <a>Description: SpringSecurityHelloWorldApplication <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2022/6/12 22:00
 * @since 1.0
 */
@SpringBootApplication
public class SpringSecurityHelloWorldApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringSecurityHelloWorldApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}
