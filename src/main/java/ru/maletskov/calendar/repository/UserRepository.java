package ru.maletskov.calendar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.maletskov.calendar.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
