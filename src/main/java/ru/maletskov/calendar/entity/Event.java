package ru.maletskov.calendar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {


    private UUID id;

    private UUID userId;

    private String name;

    private ZonedDateTime startDateTime;

    private ZonedDateTime endDateTime;

    private Boolean allDayEvent;

    private String description;

    private EventType type;

    private UUID organizer;
}
