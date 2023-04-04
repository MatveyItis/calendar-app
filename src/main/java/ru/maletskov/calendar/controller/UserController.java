package ru.maletskov.calendar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.maletskov.calendar.entity.User;
import ru.maletskov.calendar.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/app/calendar/v1/user")
    public Mono<User> createUser(@RequestBody User user) {
        return Mono.just(userService.createUser(user.getUsername()));
    }
}
