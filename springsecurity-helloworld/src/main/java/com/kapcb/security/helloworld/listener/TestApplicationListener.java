package com.kapcb.security.helloworld.listener;

import com.kapcb.security.helloworld.event.TestApplicationEvent;
import com.kapcb.security.helloworld.pojo.bo.EventBO;
import org.springframework.context.ApplicationListener;

/**
 * <a>Title: TestApplicationListener </a>
 * <a>Author: cb <a>
 * <a>Description: TestApplicationListener <a>
 *
 * @author cb
 * @version 1.0
 * @date 2022/7/2 12:22
 * @since 1.0
 */
public class TestApplicationListener implements ApplicationListener<TestApplicationEvent> {

    @Override
    public void onApplicationEvent(TestApplicationEvent event) {
        EventBO source = (EventBO) event.getSource();


    }

}
