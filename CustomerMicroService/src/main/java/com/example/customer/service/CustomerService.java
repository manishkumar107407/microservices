package com.example.customer.service;
import java.util.List;
import java.util.Optional;

import com.example.customer.dto.CustomerDto;

public interface CustomerService {	
	
	public CustomerDto addCutomer(CustomerDto customerDto);
	
	public Optional<CustomerDto> GetCutomerById(String id);
	
	public List<CustomerDto> GetAllCustomer();
	
	
	
}
