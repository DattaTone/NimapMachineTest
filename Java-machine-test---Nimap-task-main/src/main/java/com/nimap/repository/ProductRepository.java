package com.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
