package com.training.payload;




public class RequestPayload {
	
	private String email;
	
	
	private int plan;
	
	
	public RequestPayload(String email, int plan) {
		this.email=email;
		this.plan=plan;
		// TODO Auto-generated constructor stub
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getPlan() {
		return plan;
	}


	public void setPlan(int plan) {
		this.plan = plan;
	}


	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

}

