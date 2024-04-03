package com.example.order.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class MyObjectMapper {
	
	
	@Bean
	ObjectMapper getModelMapper()
	{
		return new ObjectMapper();	
	}

}
