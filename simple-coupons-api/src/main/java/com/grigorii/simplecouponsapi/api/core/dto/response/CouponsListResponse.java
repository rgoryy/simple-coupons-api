package com.grigorii.simplecouponsapi.api.core.dto.response;

import java.util.List;

public record CouponsListResponse (

    List<CouponResponse> coupons,

    Integer totalPages,

    Long totalElements,

    Integer currentPage,

    Integer pageSize

) {

}
