package ru.maletskov.calendar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Builder
@RedisHash
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private UUID id;

    private String username;

    private LocalDate birthday;

    private String hashPassword;

    private String email;

    private Boolean googleLogin;

    private ZonedDateTime createdTime;

}
