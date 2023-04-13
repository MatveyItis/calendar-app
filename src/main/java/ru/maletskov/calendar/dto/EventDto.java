package ru.maletskov.calendar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.maletskov.calendar.entity.EventType;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private UUID userId;

    private String name;

    private ZonedDateTime startDateTime;

    private ZonedDateTime endDateTime;

    private Boolean allDayEvent;

    private String description;

    private EventType type;

    private UUID organizer;

}
