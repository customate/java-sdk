package com.customate.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for connection with the frontend API.
 * 
 * Date: 03-Jun-21
 * Time: 2:05 PM
 *
 * @author Sav Balac
 * @version 1.0
 */
@Configuration
public class TestConfiguration {
    @Value("${customate.baseUrl}")
    private String baseUrl;

    @Value("${customate.version}")
    private String version;

    @Value("${customate.apiKey}")
    private String apiKey;

    @Value("${customate.apiSecret}")
    private String apiSecret;

    public String getBaseUrl() {
        return baseUrl;
    }
    public String getVersion() {
        return version;
    }
    public String getApiKey() {
        return apiKey;
    }
    public String getaApiSecret() {
        return apiSecret;
    }
}
