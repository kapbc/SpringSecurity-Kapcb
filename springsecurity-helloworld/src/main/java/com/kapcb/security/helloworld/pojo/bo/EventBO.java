package com.kapcb.security.helloworld.pojo.bo;

/**
 * <a>Title: EventBO </a>
 * <a>Author: cb <a>
 * <a>Description: EventBO <a>
 *
 * @author cb
 * @version 1.0
 * @date 2022/7/2 12:23
 * @since 1.0
 */
public class EventBO {

    private String name;

    public EventBO(){}

    public EventBO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EventBO{" +
                "name='" + name + '\'' +
                '}';
    }

}
