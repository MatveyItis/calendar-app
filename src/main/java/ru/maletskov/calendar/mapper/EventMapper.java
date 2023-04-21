package ru.maletskov.calendar.mapper;

import org.springframework.stereotype.Component;
import ru.maletskov.calendar.dto.EventDto;
import ru.maletskov.calendar.entity.Event;
import ru.maletskov.calendar.entity.EventType;

import java.util.Optional;
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


    public Event toEvent(EventDto eventDto) {

        if (!eventDto.getStartDateTime().isBefore(eventDto.getEndDateTime())) {
            throw new IllegalArgumentException("Your event start time is later or same as event end time");
        }

        return Event.builder()
                .id(UUID.randomUUID())
                .userId(eventDto.getUserId())
                .name(eventDto.getName())
                .startDateTime(eventDto.getStartDateTime())
                .endDateTime(eventDto.getEndDateTime())
                .allDayEvent(eventDto.isAllDayEvent())
                .description(eventDto.getDescription())
                .type(Optional.ofNullable(eventDto.getType()).orElse(EventType.MEETING))
                .organizer(eventDto.getUserId())
                .build();
    }
}
