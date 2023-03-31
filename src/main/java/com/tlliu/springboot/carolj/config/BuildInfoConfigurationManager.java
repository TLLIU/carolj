package com.tlliu.springboot.carolj.config;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;

public class BuildInfoConfigurationManager {
    private final static Logger LOG = LoggerFactory.getLogger(BuildInfoConfigurationManager.class);

    private BuildInfoConfiguration buildInfoConfiguration = null;

    private static BuildInfoConfigurationManager instance = new BuildInfoConfigurationManager();

    public static BuildInfoConfigurationManager getInstance() {
        return instance;
    }

    private BuildInfoConfigurationManager() {
        if (this.buildInfoConfiguration == null) {
            this.buildInfoConfiguration = loadBuildInfoConfiguration();
        }
    }

    public BuildInfoConfiguration getBuildInfoConfiguration() {
        return buildInfoConfiguration;
    }

    public BuildInfoConfiguration reloadBuildInfoConfiguration(InputStream buildInfoInput) {
        JAXBContext jc;
        BuildInfoConfiguration buildInfoConfiguration = null;
        try {
            jc = JAXBContext.newInstance(BuildInfoConfiguration.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            buildInfoConfiguration = (BuildInfoConfiguration)unmarshaller.unmarshal(buildInfoInput); 
        } catch (JAXBException e) {
            LOG.error("Failed in loading build info configuration", e);
        }
        return buildInfoConfiguration;
    }

    @SuppressWarnings("resource")
    public BuildInfoConfiguration loadBuildInfoConfiguration() {
        //ResourceLoader
        Resource resource = new ClassPathResource("build-info-cfg.xml");
        try (InputStream input = resource.getInputStream()){
            return reloadBuildInfoConfiguration(input);
        } catch (Exception e) {
            LOG.error("Failed in loading build info configuration file", e);
        }
        return null;

    }
}
