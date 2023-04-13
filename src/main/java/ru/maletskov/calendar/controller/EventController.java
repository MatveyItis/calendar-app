package ru.maletskov.calendar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.maletskov.calendar.dto.EventDto;
import ru.maletskov.calendar.entity.Event;
import ru.maletskov.calendar.service.EventService;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping("/app/calendar/v1/event")
    public Mono<Event> createEvent(@RequestBody EventDto eventDto){
        return eventService.createEvent(eventDto);
    }
}
