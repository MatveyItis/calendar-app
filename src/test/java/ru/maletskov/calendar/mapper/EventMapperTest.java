package ru.maletskov.calendar.mapper;

import org.junit.jupiter.api.Test;
import ru.maletskov.calendar.dto.EventDto;

import java.time.ZonedDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EventMapperTest {

    @Test
    public void shouldThrowException_SameTime() {
        EventMapper eventMapper = new EventMapper();
        EventDto eventDto = EventDto.builder()
                .userId(UUID.randomUUID())
                .name("Amigo")
                .startDateTime(ZonedDateTime.parse("2023-04-16T10:15:30+01:00[Europe/Paris]"))
                .endDateTime(ZonedDateTime.parse("2023-04-16T10:15:30+01:00[Europe/Paris]"))
                .build();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            eventMapper.toEvent(eventDto);
        });

        String expectedMessage = "Your event start time is later or same as event end time";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void shouldThrowException_EndTimeEarlierThanStartTime() {
        EventMapper eventMapper = new EventMapper();
        EventDto eventDto = EventDto.builder()
                .userId(UUID.randomUUID())
                .name("Amigo")
                .startDateTime(ZonedDateTime.parse("2023-04-16T10:15:30+01:00[Europe/Paris]"))
                .endDateTime(ZonedDateTime.parse("2023-04-16T10:14:30+01:00[Europe/Paris]"))
                .build();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            eventMapper.toEvent(eventDto);
        });

        String expectedMessage = "Your event start time is later or same as event end time";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}