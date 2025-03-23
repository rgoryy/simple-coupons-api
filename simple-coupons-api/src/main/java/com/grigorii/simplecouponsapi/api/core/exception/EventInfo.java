package com.grigorii.simplecouponsapi.api.core.exception;

import org.slf4j.event.Level;
import org.springframework.http.HttpStatus;


public interface EventInfo {
    HttpStatus getStatus();
    Level getLevel();
}
