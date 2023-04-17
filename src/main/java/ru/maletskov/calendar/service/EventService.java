package ru.maletskov.calendar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.maletskov.calendar.dto.EventDto;
import ru.maletskov.calendar.entity.Event;
import ru.maletskov.calendar.mapper.EventMapper;
import ru.maletskov.calendar.repository.EventRepository;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    private final EventMapper eventMapper;

    //todo return EventDto instead of Event
    public Mono<Event> createEvent(EventDto eventDto){
        return Mono.just(eventDto)
                .map(eventMapper::toEvent)
                .map(eventRepository::save);
    }
}
