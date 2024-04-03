package com.example.order.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HandleResponse  
{
	public static ResponseEntity<Object> generateResponse(HttpStatus httpStatus,boolean error,String mesage,Object object)
	{
		try
		{
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("timestamp", System.currentTimeMillis());
		map.put("status", httpStatus.value());
		map.put("isSuccess", error);
		map.put("message", mesage);
		map.put("data", object);

		return new ResponseEntity<Object>(map,httpStatus);
		}
		catch (Exception e) {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("timestamp", new Date());
			map.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
			map.put("isSuccess", false);
			map.put("message", e.getMessage());
			map.put("data", null);
			return new ResponseEntity<Object>(map,httpStatus);
		}
	}
	
}
