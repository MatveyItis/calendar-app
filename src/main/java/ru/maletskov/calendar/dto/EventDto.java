package ru.maletskov.calendar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.maletskov.calendar.entity.EventType;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    @NotNull
    private UUID userId;

    @NotNull
    private String name;

    @NotNull
    private ZonedDateTime startDateTime;

    @NotNull
    private ZonedDateTime endDateTime;

    private boolean allDayEvent;

    private String description;

    private EventType type;

}
