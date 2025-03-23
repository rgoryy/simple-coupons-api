package com.grigorii.simplecouponsapi.api.core.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class CouponsListRequest {

    String page;

    String size;

}
