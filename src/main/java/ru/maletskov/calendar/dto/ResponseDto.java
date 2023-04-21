package ru.maletskov.calendar.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
public class ResponseDto {

    private int httpCode;
    private ZonedDateTime timestamp;

    private Object result;

    private String errorMessage;

    public ResponseDto(Object result) {
        this.result = result;
        this.timestamp = ZonedDateTime.now();
        this.httpCode = HttpStatus.OK.value();
    }

    public ResponseDto(RuntimeException ex) {
        this.errorMessage = ex.getMessage();
        this.timestamp = ZonedDateTime.now();
        this.httpCode = HttpStatus.BAD_REQUEST.value();
    }
}
