package ru.maletskov.calendar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.maletskov.calendar.dto.EventDto;
import ru.maletskov.calendar.entity.Event;
import ru.maletskov.calendar.mapper.EventMapper;
import ru.maletskov.calendar.repository.EventRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    private EventMapper eventMapper;

    public Mono<Event> createEvent(EventDto eventDto){
        Event event = eventMapper.toEvent(eventDto);
        event.setId(UUID.randomUUID());
        return Mono.just(eventRepository.save(event));
    }
}
