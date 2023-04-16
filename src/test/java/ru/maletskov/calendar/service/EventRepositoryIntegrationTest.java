package ru.maletskov.calendar.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.maletskov.calendar.config.TestRedisConfiguration;
import ru.maletskov.calendar.entity.Event;
import ru.maletskov.calendar.entity.EventType;
import ru.maletskov.calendar.repository.EventRepository;

import java.time.ZonedDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = TestRedisConfiguration.class)
public class EventRepositoryIntegrationTest {

    @Autowired
    private EventRepository eventRepository;

    @Test
    public void shouldSaveEventToRedis() {
        Event event = Event.builder()
                .id(UUID.randomUUID())
                .userId(UUID.randomUUID())
                .name("Amigo")
                .startDateTime(ZonedDateTime.parse("2023-04-16T10:15:30+01:00[Europe/Paris]"))
                .endDateTime(ZonedDateTime.parse("2023-04-20T10:15:30+01:00[Europe/Paris]"))
                .allDayEvent(true)
                .description("just simple test")
                .type(EventType.OTHER)
                .organizer(UUID.randomUUID())
                .build();

        Event saved = eventRepository.save(event);

        assertNotNull(saved);
    }
}
