package com.tlliu.springboot.carolj.config;

import java.util.Map;
import java.util.Properties;

import org.apache.commons.configuration2.CombinedConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ConfigurationConverter;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

import com.tlliu.springboot.carolj.event.ConfigurationRefreshEvent;

public class ConfigurationFactoryBean extends ProxyFactoryBean implements ResourceLoaderAware, 
    InitializingBean /*, ApplicationListener<ConfigurationRefreshEvent> */{
    private final static Logger LOG = LoggerFactory.getLogger(ConfigurationFactoryBean.class);
    private ResourcePatternResolver resourcePatternResolver;
    private String[] configLocations;
    private ConfigurationTargetSource configurationTragetSource = new ConfigurationTargetSource();

    public void setConfigLocations(String[] configLocations) {
        this.configLocations = configLocations;
    }

    public final void setConfigParams(Map<String, String> configParams) {

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // postProcessConfigLocations(configLocations);
        // processConfigFragments();
    }

    public void onApplicationEvent(ConfigurationRefreshEvent event){
        if(event.getSource() != this) {
            // refresh(event.getSource());
        }
    }

    // public void init() {
    //     addInterface(Configuration.class);
    //     addAdvice(new ConfigurationInterceptor());
    //     setFrozen(true);
    //     setTargetSource(configurationTragetSource);
    // }

    // private void refresh(Object eventSource) {
    //     try {
    //         ConfigurationLock.instance().refreshBegin();
    //         processConfigFragments();
    //     } finally {
    //         ConfigurationLock.instance().refreshEnd();
    //     }

    // }

    // private void processConfigFragments() {
    //     ConfigurationFragment[] configFragments = readConfigFragments();
    //     CombinedConfiguration combinedConfiguration = new CombinedConfiguration();
    //     combinedConfiguration.setForceReloadCheck(isReloadChecked());
    //     for (ConfigurationFragment configFragment : configFragments) {
    //         combinedConfiguration.addConfiguration(configFragment.getFragment());
    //     }
    //     ConfigurationSource.setConfigLocation(combinedConfiguration);
    //     LOG.info("Reloading System Configs");
    // }

    // private ConfigurationFragment[] readConfigFragments() {
    //     ConfigurationReader configurationReader = null ;
    //     if (this.reloadingStrategyFactoryBean != null) {
    //         configurationReader = new ConfigurationReader(this.resourcePatternResolver, this.reloadingStrategyFactoryBean);
    //     } else {
    //         configurationReader = new ConfigurationReader(this.resourcePatternResolver);
    //     }
    //     return configurationReader.readConfigurationFragment(configLocations);

    // }

    // public void postProcessConfigLocations(String[] configLocations) {

    // }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourcePatternResolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
    }

    public Properties gProperties() {
        Configuration configuration = null;
        try {
            configuration = (Configuration)configurationTragetSource.getTarget();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return ConfigurationConverter.getProperties(configuration);
    }


    
}
