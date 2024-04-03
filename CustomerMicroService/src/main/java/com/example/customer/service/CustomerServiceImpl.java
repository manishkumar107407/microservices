package com.example.customer.service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.customer.dto.CustomerDto;
import com.example.customer.dto.Order;
import com.example.customer.entities.Customer;
import com.example.customer.figen.OrderService;
import com.example.customer.repositories.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
 

@Service
public class CustomerServiceImpl implements CustomerService
{
	CustomerRepository customerRepository;
	ObjectMapper objectMapper;
	OrderService orderService;
	
	public CustomerServiceImpl(CustomerRepository customerRepository,ObjectMapper objectMapper,OrderService orderService)
	{
	this.customerRepository=customerRepository;
	this.objectMapper=objectMapper;
	this.orderService=orderService;
	}

	@Override
	public CustomerDto addCutomer(CustomerDto customerDto) {
		Customer customer = objectMapper.convertValue(customerDto,Customer.class);
		Customer customer2 = customerRepository.save(customer);
		CustomerDto customerDto2 = objectMapper.convertValue(customer2,CustomerDto.class);
		return customerDto2;
	}

	@Override
	public Optional<CustomerDto> GetCutomerById(String id) {
		   Customer customer = customerRepository.findById(id).get();   
			CustomerDto customerDto2 = objectMapper.convertValue(customer,CustomerDto.class);
			   			   ResponseEntity<Object> orderByCutomer = orderService.getOrderByCutomer(id);

			    Object body = orderByCutomer.getBody();
			   
			   customerDto2.setOrder(body);
			   
			return Optional.ofNullable(customerDto2);
	}

	@Override
	public List<CustomerDto> GetAllCustomer() {
		List<Customer> all = customerRepository.findAll();
		List<CustomerDto> asList = Arrays.asList(objectMapper.convertValue(all,CustomerDto[].class));
	
		return asList;
	}

	
	 

}
