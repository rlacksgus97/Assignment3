package com.bd.assignment3.batch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@Service
@RequiredArgsConstructor
public class ApiService {

    private final ObjectMapper objectMapper;

    @Value("${apiKey}")
    private String apiKey;

    private final String url = "https://api.odcloud.kr/api/3074271/v1/uddi:cfc19dda-6f75-4c57-86a8-bb9c8b103887";

    private static int page = 1;
    private static int perPage = 10;

    public ApiResDto call() throws JsonProcessingException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        httpHeaders.add("Authorization", apiKey);

        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url+"?page="+page+"&perPage="+perPage, HttpMethod.GET, httpEntity, String.class);

        ApiResDto apiResDto = objectMapper.readValue(responseEntity.getBody(), ApiResDto.class);
        System.out.println("apiResDto = " + apiResDto);

        return apiResDto;
    }
}
