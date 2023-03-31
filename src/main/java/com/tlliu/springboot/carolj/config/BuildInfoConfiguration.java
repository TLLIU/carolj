package com.tlliu.springboot.carolj.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="configuration")
public class BuildInfoConfiguration {
    String group;
    List<AppBuildInfo> appBuildInfos = new ArrayList<AppBuildInfo>();

    @XmlAttribute(name="group")
    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @XmlElement(name="app-build-info")
    public List<AppBuildInfo> getAppBuildInfos() {
        return appBuildInfos;
    }

    public void setAppBuildInfo(List<AppBuildInfo> appBuildInfos) {
        this.appBuildInfos = appBuildInfos;
    }

    
}
