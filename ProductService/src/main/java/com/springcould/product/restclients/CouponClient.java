/**
 * 
 */
package com.springcould.product.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springcould.product.dto.Coupon;

/**
 * @author Suresh Sadanala
 *
 */
@FeignClient("COUPON-SERVICE")
public interface CouponClient {
	@GetMapping("/couponapi/coupon/{code}")
	Coupon getCoupon(@PathVariable("code") String code);
}
