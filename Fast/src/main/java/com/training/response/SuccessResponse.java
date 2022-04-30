package com.training.response;

import java.util.Dictionary;
import java.util.Hashtable;

public class SuccessResponse {
	Dictionary dict=new Hashtable();
	public Dictionary insert(String key,String value) {		
		dict.put(key, value);		
		return dict;
	}
	

}
