package ru.maletskov.calendar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.maletskov.calendar.entity.User;
import ru.maletskov.calendar.repository.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(String name) {
        return userRepository.save(User.builder()
                .id(UUID.randomUUID())
                .username(name)
                .build());
    }
}
