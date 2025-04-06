package com.nimap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
