package ru.maletskov.calendar.mapper;

import org.springframework.stereotype.Component;
import ru.maletskov.calendar.dto.EventDto;
import ru.maletskov.calendar.entity.Event;

@Component
public class EventMapper {

    public EventDto toDto(Event event) {
        return new EventDto(
                event.getUserId(),
                event.getName(),
                event.getStartDateTime(),
                event.getEndDateTime(),
                event.getAllDayEvent(),
                event.getDescription(),
                event.getType(),
                event.getOrganizer()
        );
    }

    public Event toEvent(EventDto eventDto){
        return Event.builder()
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
