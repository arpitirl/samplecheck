package com.training.processor;

import java.util.Dictionary;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.training.payload.RequestPayload;
import com.training.response.FailResponse;
import com.training.response.SuccessResponse;

@Component
public class Processor {
	SuccessResponse success=new SuccessResponse();
	FailResponse fail=new FailResponse();
	
	public ResponseEntity<String> apiCall(String email,int plan){
		String url1="http://localhost:9000/enrolluser";
		RequestPayload request1=new RequestPayload(email,plan);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForEntity(url1,request1,String.class);
		
	}
	@Async("asyncExecution")
	public Dictionary process(List<String> list) {
		System.out.println("Processor");
		System.out.println("Current Thread Name- " + Thread.currentThread().getName());
		if(list==null) {
			System.out.println("List is null");
			return null;
		}
		for(int i=0;i<list.size();i+=3) {
			if(list.size()<3) {
				return success.insert("","");
			}
			String email=list.get(i);
			String p=list.get(i+1);
			String mobile=list.get(i+2);
			if(email.matches(".*@zee.com")){
				if(mobile.matches("\\d{10}")) {
					int plan = Integer.parseInt(p);
					try {
						ResponseEntity<String> response2 =apiCall(email, plan);
					
//					ResponseEntity<String> response2 =apiCall(email, plan);
					String invs2 = response2.getBody();
					if (invs2.toString().equals("Invalid")) 
					{
					    success.insert(email,"Failed");							
					}
					else if (invs2.toString().equals("User Already Exists")) 
					{
						success.insert(email,"User Already Exists");						
					}
					else 
					{
						success.insert(email,"Granted");						
					}
					
				}
				 catch (Exception e) {
					// TODO: handle exception
					fail.insert(email, "Error");
				}
				}
				else {
					success.insert(email,"Invalid mobile Number");					
				}
			}
			else {
				success.insert(email,"Invalid Email Domain");				
		}		
	}
		return success.insert("","");
	}
}
