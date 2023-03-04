package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.entities.PlanCategory;

public interface PlanCategoryRepository extends JpaRepository<PlanCategory, Integer> {

}
