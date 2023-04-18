package ru.maletskov.calendar.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;
import ru.maletskov.calendar.dto.EventDto;
import ru.maletskov.calendar.dto.ResponseDto;
import ru.maletskov.calendar.service.EventService;

import javax.validation.Valid;

@Log4j2
@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping("/app/calendar/v1/event")
    public Mono<ResponseEntity<ResponseDto>> createEvent(@Valid @RequestBody Mono<EventDto> eventDto) {
        return eventDto
                .flatMap(eventService::createEvent)
                .map(ResponseDto::new)
                .map(ResponseEntity::ok)
                .onErrorResume(WebExchangeBindException.class,
                        ex -> Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                                new ResponseDto(ex))));
    }
}
