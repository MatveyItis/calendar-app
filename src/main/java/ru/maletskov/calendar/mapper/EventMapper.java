package ru.maletskov.calendar.mapper;

import org.springframework.stereotype.Component;
import ru.maletskov.calendar.dto.EventDto;
import ru.maletskov.calendar.entity.Event;

import java.util.UUID;

@Component
public class EventMapper {

    public EventDto toDto(Event event) {
        return EventDto.builder()
                .userId(event.getUserId())
                .name(event.getName())
                .startDateTime(event.getStartDateTime())
                .endDateTime(event.getEndDateTime())
                .allDayEvent(event.getAllDayEvent())
                .description(event.getDescription())
                .type(event.getType())
                .organizer(event.getOrganizer())
                .build();
    }


    public Event toEvent(EventDto eventDto){
        return Event.builder()
                .id(UUID.randomUUID())
                .userId(eventDto.getUserId())
                .name(eventDto.getName())
                .startDateTime(eventDto.getStartDateTime())
                .endDateTime(eventDto.getEndDateTime())
                .allDayEvent(eventDto.getAllDayEvent())
                .description(eventDto.getDescription())
                .type(eventDto.getType())
                .organizer(eventDto.getOrganizer())
                .build();
    }
}
