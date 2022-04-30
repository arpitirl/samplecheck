package com.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.training.entity.Plan;
import com.training.entity.Register;

import com.training.payload.RequestPayload;
import com.training.repository.PlanRepository;
import com.training.repository.RegisterRepository;


@Service
public class UserService {
	@Autowired
	private RegisterRepository repository;
	@Autowired
	private PlanRepository planRepo;
	public String enrollUser(RequestPayload user) {		
		
				if(repository.existsByEmail(user.getEmail())) {
					return("User Already Exists");
				}
				else {
					return(saving(user));
				}
				
			}
	public String saving(RequestPayload user) {
		
		Register s= new Register(user.getEmail());
		
		
		Optional<Plan> plan=planRepo.findByPlan(user.getPlan());
		
		if(plan.isEmpty()) {
			
			s.setPlan(planRepo.save(new Plan(user.getPlan())));
		}
		else {
			
			s.setPlan(plan.get());
		}
		
		Register s1=repository.save(s);
		
		return("User Enrolled");
	}
public String deleteById(int id) {
		
		repository.deleteById(id);
		return("Transaction Successfull");
	}
public Optional<Register> getById(int id) {
	return repository.findById(id);
}
public List<Register> getUsers() {
	return repository.findAll();
}
public String updateUser(int id, RequestPayload user) {
	if(!repository.existsById(id)) {
		return("Invalid Request");
	}
	System.out.println("Hi I m");
	Register s= new Register(user.getEmail());
	s.setId(id);
	
	System.out.println("Hi I m1");
	Optional<Plan> plan=planRepo.findByPlan(user.getPlan());
	System.out.println("Hi I m2");
	if(plan.isEmpty()) {
		System.out.println("Hi I m here");
		s.setPlan(planRepo.save(new Plan(user.getPlan())));
	}
	else {
		System.out.println("Hi I m there");
		s.setPlan(plan.get());
	}
	System.out.println("Hi I m there1");
	Register s1=repository.save(s);
	System.out.println("Hi I m there2");
	
	return("Update Successfull");
}
	
	

}
