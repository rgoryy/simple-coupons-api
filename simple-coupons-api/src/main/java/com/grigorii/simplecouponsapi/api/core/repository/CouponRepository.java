package com.grigorii.simplecouponsapi.api.core.repository;

import com.grigorii.simplecouponsapi.api.core.entiry.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends PagingAndSortingRepository<Coupon, Long> {

    Optional<Coupon> findById(Long id);

}
