package com.tlliu.springboot.carolj.event;

import org.springframework.context.ApplicationEvent;

public class ConfigurationRefreshEvent extends ApplicationEvent {
    public ConfigurationRefreshEvent(Object source) {
        super(source);
    }
}
