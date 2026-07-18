package com.qacart.todo.utils;

import java.util.Properties;

public class ConfigUtils {
    private Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils(){
        String env = System.getProperty("env" , "PRODUCTION");
        switch (env){
            case "PRODUCTION":
                properties = PropertiesUtil.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
                break;
            case "LOCAL":
                properties = PropertiesUtil.loadProperties("src/test/java/com/qacart/todo/config/local.properties");
                break;
            default:
                throw new RuntimeException("Env not supported");
        }
}

    public static ConfigUtils getInstance(){
        if (configUtils == null){
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }
    public String getBaseUrl(){
        String prop =  properties.getProperty("baseUrl");
        if (prop != null) return prop;
            throw new RuntimeException("baseUrl not found in properties file");
    }
    public String getEmail(){
        String prop =  properties.getProperty("email");
        if (prop != null) return prop;
        throw new RuntimeException("Email not found in properties file");
    }
    public String getPassword(){
        String prop =  properties.getProperty("password");
        if (prop != null) return prop;
        throw new RuntimeException("Password not found in properties file");
    }
}
