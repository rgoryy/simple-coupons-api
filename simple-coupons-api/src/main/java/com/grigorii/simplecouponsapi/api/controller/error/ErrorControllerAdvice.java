package com.grigorii.simplecouponsapi.api.controller.error;

import com.grigorii.simplecouponsapi.api.core.dto.response.ErrorResponse;
import com.grigorii.simplecouponsapi.api.core.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestControllerAdvice
public class ErrorControllerAdvice {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException exception) {
        Level level = exception.getEventInfo().getLevel();
        var status = exception.getEventInfo().getStatus();
        log.atLevel(level).log(exception.getMessage() + " with status code: " + status);
        return handleCustomException(exception, status);
    }

    private ResponseEntity<ErrorResponse> handleCustomException(Exception exception, HttpStatus status) {
        return ResponseEntity.status(status).body(body(exception.getMessage(), status.value()));
    }

    private ErrorResponse body(String message, Integer code) {
        return new ErrorResponse(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), message, code);
    }
}
