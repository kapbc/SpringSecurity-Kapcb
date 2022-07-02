package com.kapcb.security.helloworld.event;

import com.kapcb.security.helloworld.pojo.bo.EventBO;
import org.springframework.context.ApplicationEvent;

/**
 * <a>Title: TestApplicationEvent </a>
 * <a>Author: cb <a>
 * <a>Description: TestApplicationEvent <a>
 *
 * @author cb
 * @version 1.0
 * @date 2022/7/2 12:23
 * @since 1.0
 */
public class TestApplicationEvent extends ApplicationEvent {

    public TestApplicationEvent(EventBO eventBO) {
        super(eventBO);
    }

}
