package com.bd.assignment3.batch;

import com.bd.assignment3.research.ResearchRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@RequiredArgsConstructor
public class ResearchItemReader implements ItemReader<ApiResDto> {

    private final ObjectMapper objectMapper;

    @Value("${apiKey}")
    private String apiKey;
    private final String url = "https://api.odcloud.kr/api/3074271/v1/uddi:cfc19dda-6f75-4c57-86a8-bb9c8b103887";

//    private int page = CustomJobListner.page;
    private final int perPage = 10;

    @Override
    public ApiResDto read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (BatchConfig.page > 10) {
            return null;
        }
        System.out.println("page = " + BatchConfig.page);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        httpHeaders.add("Authorization", apiKey);

        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url+"?page="+BatchConfig.page+"&perPage="+perPage, HttpMethod.GET, httpEntity, String.class);

        ApiResDto apiResDto = objectMapper.readValue(responseEntity.getBody(), ApiResDto.class);
        System.out.println("ResearchItemReader.read");
        BatchConfig.page += 1;
        return apiResDto;
    }
}
