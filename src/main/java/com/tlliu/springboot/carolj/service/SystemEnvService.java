package com.tlliu.springboot.carolj.service;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

@FunctionalInterface
public interface SystemEnvService {
    public static final String UNKNOWN = "Unknown";
    public Map<String, String> getSystemEnv();

    default String getOSName() {
        return System.getProperty("os.name", UNKNOWN);
    }

    default String getOSVersion() {
        return System.getProperty("os.version", UNKNOWN);
    }
    default String getJVM() {
        return System.getProperty("java.vender", UNKNOWN);
    }

    default String getJDKVersion() {
        return System.getProperty("java.version", UNKNOWN);
    }

}
