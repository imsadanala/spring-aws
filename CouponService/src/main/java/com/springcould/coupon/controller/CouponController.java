/**

 * 
 */
package com.springcould.coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcould.coupon.entity.Coupon;
import com.springcould.coupon.repos.CouponRepo;

/**
 * @author Suresh Sadanala
 *
 */

@RestController
@RequestMapping("/couponapi")
public class CouponController {

	@Autowired
	CouponRepo couponRepo;

	@PostMapping(value = "/coupons")
	public Coupon create(@RequestBody Coupon coupon) {
		return couponRepo.save(coupon);
	}
	
	@GetMapping(value = "/coupon/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		return couponRepo.findByCode(code);
	}

}
