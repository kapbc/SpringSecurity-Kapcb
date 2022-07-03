package com.kapcb.security.helloworld.listener;

import com.kapcb.security.helloworld.event.TestApplicationEvent;
import com.kapcb.security.helloworld.pojo.bo.EventBO;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

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
@Component
public class TestApplicationListener implements ApplicationListener<TestApplicationEvent> {

    @Override
    public void onApplicationEvent(TestApplicationEvent event) {
        EventBO source = (EventBO) event.getSource();
        System.out.println("Hello " + source.getName() + " this is Spring Application Event!");
    }

}
