package com.training.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.entity.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {

	Optional<Plan> findByPlan(int plan);

}
