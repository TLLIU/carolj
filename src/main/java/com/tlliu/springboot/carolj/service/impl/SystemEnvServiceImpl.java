package com.tlliu.springboot.carolj.service.impl;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tlliu.springboot.carolj.config.BuildInfoConfiguration;
import com.tlliu.springboot.carolj.config.BuildInfoConfigurationManager;
import com.tlliu.springboot.carolj.config.ConfigurationFactoryBean;
import com.tlliu.springboot.carolj.service.SystemEnvService;

@Service
public class SystemEnvServiceImpl  implements SystemEnvService{
    private final static Logger LOG = LoggerFactory.getLogger(SystemEnvServiceImpl.class);
    //private ConfigurationFactoryBean configurationFactoryBean;
    private static final String UNKOWN = "Unknown";
    private static final String ATTR_OS = "OS";
    private static final String ATTR_OS_VERSION = "OS VERSION";
    private static final String ATTR_IP_ADDRESS = "IP Address";
    private static final String ATTR_HOST_NAME = "DEPLOYMENT TOKEN";
    private static final String ATTR_JVM = "JVM";
    private static final String ATTR_JDK = "JDK";
    private static final String ATTR_BUILD_NUMBER = "Build No.";
    private static final String ATTR_BUILD_NAME = "Build Name.";

    @Override
    public Map<String, String> getSystemEnv() {
        //Configuration config = (Configuration)configurationFactoryBean.getObject();
        BuildInfoConfiguration buildInfoConfig = BuildInfoConfigurationManager.getInstance().getBuildInfoConfiguration();
        Map<String, String> envMap = new HashMap();
        envMap.put(ATTR_OS, this.getOSName());
        envMap.put(ATTR_OS_VERSION, this.getOSVersion());
        envMap.put(ATTR_IP_ADDRESS, this.getOSName());
        envMap.put(ATTR_HOST_NAME, this.getOSName());
        envMap.put(ATTR_JVM, this.getOSName());
        envMap.put(ATTR_JDK, this.getOSName());
        envMap.put(ATTR_BUILD_NUMBER, buildInfoConfig == null ? UNKOWN : buildInfoConfig.getAppBuildInfos().get(0).getBuildVersion());
        envMap.put(ATTR_BUILD_NAME, buildInfoConfig == null ? UNKOWN : buildInfoConfig.getAppBuildInfos().get(0).getBuildName());
        // envMap.put(ATTR_BUILD_NUMBER, config == null ? UNKOWN : config.subset("app-build-info").getString("build-version", UNKOWN));
        // envMap.put(ATTR_BUILD_NAME, config == null ? UNKOWN : config.subset("app-build-info").getString("build-name", UNKOWN));
        envMap.putAll(getNetworkInfo());
        return envMap;
    }
    
    private Map<String, String> getNetworkInfo() {
        Map<String, String> networkInfo = new HashMap<>();
        try {
            InetAddress thisHostAddress = InetAddress.getLocalHost();
            String ipAddress = thisHostAddress.getHostAddress();
            String hostName = thisHostAddress.getHostName();
            networkInfo.put(ATTR_IP_ADDRESS, ipAddress);
            networkInfo.put(ATTR_HOST_NAME, hostName);
        } catch (Exception ex) {
            LOG.error("Failed to get host address");
        }
        return networkInfo;
    }

    // public void setConfigurationFactoryBean(ConfigurationFactoryBean configurationFactoryBean) {
    //     this.configurationFactoryBean = configurationFactoryBean;
    // }
    
}
