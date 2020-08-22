/**
 * 
 */
package com.springcould.coupon.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcould.coupon.entity.Coupon;

/**
 * @author Suresh Sadanala
 *
 */
public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
