package com.bd.assignment3.batch;

import com.bd.assignment3.research.Research;
import com.bd.assignment3.research.ResearchRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.nio.charset.Charset;

@Component
@RequiredArgsConstructor
public class ApiScheduler {

    private final ObjectMapper objectMapper;
    private final ResearchRepository researchRepository;

    @Value("${apiKey}")
    private String apiKey;

    private final String url = "https://api.odcloud.kr/api/3074271/v1/uddi:cfc19dda-6f75-4c57-86a8-bb9c8b103887";

//    private static int page = 1;
    private static int perPage = 10;

    @Scheduled(cron = "00 13 14 ? * 1")
    @Transactional
    public void call() throws JsonProcessingException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        httpHeaders.add("Authorization", apiKey);

        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        for (int page=1; page<16; page++) {
            ResponseEntity<String> responseEntity = restTemplate.exchange(url+"?page="+page+"&perPage="+perPage, HttpMethod.GET, httpEntity, String.class);

            ApiResDto apiResDto = objectMapper.readValue(responseEntity.getBody(), ApiResDto.class);
            System.out.println("apiResDto = " + apiResDto);

            for (Research r : apiResDto.getData()) {
                researchRepository.save(r);
            }
        }
    }
}
