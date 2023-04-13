package ru.maletskov.calendar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.maletskov.calendar.entity.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {
}
