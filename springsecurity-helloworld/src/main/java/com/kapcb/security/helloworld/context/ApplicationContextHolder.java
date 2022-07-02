package com.kapcb.security.helloworld.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <a>Title: ApplicationContextHolder </a>
 * <a>Author: cb <a>
 * <a>Description: ApplicationContextHolder <a>
 *
 * @author cb
 * @version 1.0
 * @date 2022/7/2 12:18
 * @since 1.0
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ApplicationContextHolder.applicationContext == null) {
            ApplicationContextHolder.applicationContext = applicationContext;
        }
    }

    public static <T> void publishEvent(T applicationEvent) {
        applicationContext.publishEvent(applicationEvent);
    }

}
