package com.example.personalservice.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "numberGenerator", url = "number-generator:8080")
public interface NumberGeneratorClient {
    @GetMapping("/number")
    ResponseEntity<Long> getNumber();
}
