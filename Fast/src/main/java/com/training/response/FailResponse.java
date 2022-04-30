package com.training.response;

import java.util.Dictionary;
import java.util.Hashtable;

public class FailResponse {
	Dictionary dict=new Hashtable();
	public void insert(String key,String value) {
		dict.put(key, value);
	}
	public Dictionary failResponse() {
		return dict;
	}

}
