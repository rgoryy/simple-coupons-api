package com.grigorii.simplecouponsapi.api.core.service;

import com.grigorii.simplecouponsapi.api.core.dto.response.CouponResponse;
import com.grigorii.simplecouponsapi.api.core.dto.response.CouponsListResponse;
import com.grigorii.simplecouponsapi.api.core.entiry.Coupon;
import com.grigorii.simplecouponsapi.api.core.exception.BusinessException;
import com.grigorii.simplecouponsapi.api.core.exception.CouponEvent;
import com.grigorii.simplecouponsapi.api.core.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;



    public CouponsListResponse getCoupons(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Coupon> couponPage = couponRepository.findAll(pageable);

        List<CouponResponse> couponResponses = couponPage.stream()
                .map(coupon -> new CouponResponse(
                        coupon.getId(),
                        coupon.getTitle(),
                        coupon.getImageUrl(),
                        coupon.getLocation(),
                        coupon.getPrice(),
                        coupon.getValidityPeriod(),
                        coupon.getDescription()
                ))
                .toList();

        return new CouponsListResponse(
                couponResponses,
                couponPage.getTotalPages(),
                couponPage.getTotalElements(),
                couponPage.getNumber(),
                couponPage.getSize()
        );
    }

    public CouponResponse getCouponById(Long id) {
        Optional<Coupon> optionalCoupon = couponRepository.findById(id);
        if (optionalCoupon.isPresent()) {
            Coupon coupon = optionalCoupon.get();
            return new CouponResponse(
                    coupon.getId(),
                    coupon.getTitle(),
                    coupon.getImageUrl(),
                    coupon.getLocation(),
                    coupon.getPrice(),
                    coupon.getValidityPeriod(),
                    coupon.getDescription()
            );
        }
        throw new BusinessException(
                CouponEvent.COUPON_WITH_THIS_ID_IS_NOT_FOUND,
                "Coupon with this ID is not found!"
        );
    }

}
