package ru.maletskov.calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableRedisRepositories
@SpringBootApplication
public class CalendarAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendarAppApplication.class, args);
    }

}
