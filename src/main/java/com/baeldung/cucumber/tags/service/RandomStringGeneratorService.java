package com.baeldung.cucumber.tags.service;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RandomStringGeneratorService {
    public String get(){
        return UUID.randomUUID().toString();
    }
}
