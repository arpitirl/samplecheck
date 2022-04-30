package com.training.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.entity.Register;
@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {

	

	boolean existsByEmail(String email);

}
