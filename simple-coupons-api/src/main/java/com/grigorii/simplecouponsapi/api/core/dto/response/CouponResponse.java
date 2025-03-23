package com.grigorii.simplecouponsapi.api.core.dto.response;

public record CouponResponse(
        Long id,

        String title,

        String imageUrl,

        String location,

        String price,

        // String discount,

        String validityPeriod,

        String description
) {

}