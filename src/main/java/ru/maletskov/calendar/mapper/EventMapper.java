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
                .allDayEvent(event.isAllDayEvent())
                .description(event.getDescription())
                .type(event.getType())
                .build();
    }

    public Event toEvent(EventDto eventDto){
        if (eventDto.getStartDateTime().isAfter(eventDto.getEndDateTime())) {
            //todo add message
            throw new IllegalArgumentException("");
        }
        // todo other checks
        return Event.builder()
                .id(UUID.randomUUID())
                .userId(eventDto.getUserId())
                .name(eventDto.getName())
                .startDateTime(eventDto.getStartDateTime())
                .endDateTime(eventDto.getEndDateTime())
                .allDayEvent(eventDto.isAllDayEvent())
                .description(eventDto.getDescription())
                .type(eventDto.getType())
                .organizer(eventDto.getUserId())
                .build();
    }
}
