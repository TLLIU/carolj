package com.tlliu.springboot.carolj.config;

import org.apache.commons.configuration.Configuration;
import org.springframework.aop.TargetSource;
import org.springframework.lang.Nullable;

public class ConfigurationTargetSource implements TargetSource{
    private Configuration configuration;

    @Override
    @Nullable
    public Class<Configuration> getTargetClass() {
        return Configuration.class;
    }

    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    @Nullable
    public Object getTarget() throws Exception {
        return configuration;
    }

    @Override
    public void releaseTarget(Object target) throws Exception {
    }

    void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }


}
