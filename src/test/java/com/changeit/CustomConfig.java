package com.changeit;

import java.util.Properties;

public class CustomConfig {

    private final String customGrootTestUrl;

    CustomConfig(Properties properties) {
        customGrootTestUrl = properties.getProperty("groot.test.url.custom");
    }

    public String getCustomGrootTestUrl() {
        return customGrootTestUrl;
    }
}