package com.baeldung.cucumber.tags.controller;

import com.baeldung.cucumber.tags.service.RandomStringGeneratorService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringController {

    private final RandomStringGeneratorService generatorService;

    public StringController(RandomStringGeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @RequestMapping(value="/string-generator", produces= MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> generateString() {
        return ResponseEntity.ok(generatorService.get());
    }


}
