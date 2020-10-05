/**
 * 
 */
package com.springcould.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springcould.product.entity.Coupon;
import com.springcould.product.entity.Product;
import com.springcould.product.repos.ProductRepo;
import com.springcould.product.restclients.CouponClient;

/**
 * @author ssadanala
 *
 */
@RestController
@RequestMapping("/productapi")
public class ProductController {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Value(value = "${coupon.service.url}")
	private String couponServiceUrl;
	
	@Autowired
	private CouponClient couponClient;

	@PostMapping(value = "/products")
	public Product createProduct(@RequestBody Product product) {
		/**
		 *Using RestTemplate  
		 */
		//Coupon coupon = restTemplate.getForObject(couponServiceUrl + product.getCouponCode(), Coupon.class);
		/**
		 * Using FeignClient
		 */
		com.springcould.product.dto.Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return productRepo.save(product);
	}
}
