package com.grigorii.simplecouponsapi.api.controller;

import com.grigorii.simplecouponsapi.api.core.dto.request.CouponsListRequest;
import com.grigorii.simplecouponsapi.api.core.dto.response.CouponResponse;
import com.grigorii.simplecouponsapi.api.core.dto.response.CouponsListResponse;
import com.grigorii.simplecouponsapi.api.core.util.ApiPaths;
import com.grigorii.simplecouponsapi.api.core.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(ApiPaths.API_PREFIX)
@RequiredArgsConstructor
public class CouponController {

    // private static final String UPLOAD_DIR = "uploads/";

    private final CouponService couponService;

    @PostMapping(ApiPaths.COUPON_PREFIX)
    public CouponsListResponse getAllCoupons(@RequestBody CouponsListRequest couponsListRequest) {
        return couponService.getCoupons(
                Integer.parseInt(couponsListRequest.getPage()),
                Integer.parseInt(couponsListRequest.getSize())
        );
    }

    @GetMapping(ApiPaths.COUPON_PREFIX + "/{id}")
    public CouponResponse getCoupon(@PathVariable Long id) {
        return couponService.getCouponById(id);
    }

//    @GetMapping("/images/{filename}")
//    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException {
//        Path path = Paths.get(UPLOAD_DIR + filename);
//        Resource resource = new FileSystemResource(path);
//
//        if (resource.exists()) {
//            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(resource);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
}
