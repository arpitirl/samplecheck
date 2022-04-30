package com.training.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.entity.Register;

import com.training.payload.RequestPayload;

import com.training.service.UserService;

@RestController
public class Zee5Controller {
	@Autowired
	private UserService service;
	@PostMapping("/enrolluser")
	public String enrollUser(@RequestBody RequestPayload user) {
		return service.enrollUser(user);
		
	}

	@GetMapping("/getAll")
	public List<Register> getAll(){
		return service.getUsers();
	}
	@GetMapping("/getUser/{id}")
	public Optional<Register> getById(@PathVariable int id) {
		Optional<Register> s=service.getById(id);
		//Student st=s.get();
		//ResponsePayload response = new ResponsePayload(st.getId(), st.getEmail(), st.getFname(), st.getLname(), st.getComputer(), st.getBiology(), st.getAddress().getAddress(), st.getCourse().getCourse());
		return s;
	}
	@PutMapping("/updateuser/{id}")
	public String updateUser(@PathVariable int id,@RequestBody RequestPayload user) {
		return service.updateUser(id, user);
		
	}
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.deleteById(id);
	}
	

}
