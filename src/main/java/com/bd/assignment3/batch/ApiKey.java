package com.bd.assignment3.batch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiKey {
    @Value("${apiKey}")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    @Override
    public String toString() {
        return "ApiKey [apiKey=" + apiKey + "]";
    }
}
