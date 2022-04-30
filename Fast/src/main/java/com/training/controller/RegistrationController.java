package com.training.controller;

import java.io.IOException;
import java.util.Dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.training.payload.RequestPayload;
import com.training.processor.Processor;
import com.training.reader.Reader;
import com.training.service.RegistrationService;


@RestController
public class RegistrationController {
	@Autowired
	private RegistrationService service;
	@Autowired
	private Processor process;
	
	
//	Reader reader=new Reader();
//	RegistrationService service=new RegistrationService();
	
	@PostMapping("/upload")
	public Dictionary enrollUser(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println("Controller");
		System.out.println(process);
		return service.read(file);
		
	}
}