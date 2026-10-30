package com.tlliu.springboot.carolj.config;


import java.util.ArrayList;
import java.util.List;


import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

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
