package ru.maletskov.calendar.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
//todo create appropriate constructors
public class ResponseDto {

    private int httpCode;
    private ZonedDateTime timestamp;

    private Object result;

    private String errorMessage;

    //200 OK
    public ResponseDto(Object result) {
        this.result = result;
        this.timestamp = ZonedDateTime.now();
        this.httpCode = HttpStatus.OK.value();
    }

    //todo 400 Bad Request
}
