package com.springcould.product.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcould.product.entity.Product;

/**
 * 
 * @author ssadanala
 *
 */
public interface ProductRepo extends JpaRepository<Product, Long>{

}
