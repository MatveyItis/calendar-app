package ru.maletskov.calendar.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AboutController {

    @GetMapping(value = "/app/calendar/v1/about", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Mono<Object> about() {
        return Mono.just("{\"appName\":\"Calendar\"}");
    }
}
