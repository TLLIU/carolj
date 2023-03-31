package com.tlliu.springboot.carolj.config;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class AppBuildInfo implements Serializable {
    String buildVersion;
    @XmlElement(name="build-version")
    public String getBuildVersion() {
        return buildVersion;
    }
    public void setBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion;
    }
    String buildName;
    @XmlElement(name="build-name")
    public String getBuildName() {
        return buildName;
    }
    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }
}