package com.grigorii.simplecouponsapi.api.core.entiry;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "coupon")
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "imageUrl", nullable = true)
    private String imageUrl;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "validity_period", nullable = false)
    private String validityPeriod;

    @Column(name = "description", nullable = true)
    private String description;
}
