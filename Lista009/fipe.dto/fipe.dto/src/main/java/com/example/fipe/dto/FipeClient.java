package com.example.fipe.dto;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class FipeClient {
    private final RestClient restClient;

    public FipeClient(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://parallelum.com.br/fipe/api/v1/carros").build();
    }

    public RestClient getRestClient() {
        return restClient;
    }
}
