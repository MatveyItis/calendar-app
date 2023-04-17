package ru.maletskov.calendar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
@RedisHash
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    private UUID id;

    private UUID userId;

    private String name;

    private ZonedDateTime startDateTime;

    private ZonedDateTime endDateTime;

    private boolean allDayEvent;

    private String description;

    private EventType type;

    private UUID organizer;

}
