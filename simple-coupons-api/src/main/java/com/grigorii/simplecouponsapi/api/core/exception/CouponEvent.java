package com.grigorii.simplecouponsapi.api.core.exception;

import lombok.AllArgsConstructor;
import org.slf4j.event.Level;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public enum CouponEvent implements EventInfo {

    COUPON_WITH_THIS_ID_IS_NOT_FOUND(HttpStatus.NOT_FOUND, Level.INFO);

    private final HttpStatus status;
    private final Level level;
}