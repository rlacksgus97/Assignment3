package com.bd.assignment3.batch;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;

    @GetMapping("/call")
    public ResponseEntity<ApiResDto> call() throws JsonProcessingException {
        return ResponseEntity.ok(apiService.call());
    }
}
