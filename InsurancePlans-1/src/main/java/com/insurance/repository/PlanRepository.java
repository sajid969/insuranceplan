package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.entities.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

}
