package com.example.customer.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.dto.CustomerDto;
import com.example.customer.dto.Order;
import com.example.customer.service.CustomerService;
import com.example.customer.utils.HandleResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/customer")
@CrossOrigin("*")
public class CustomerController 
{
	
	CustomerService customerService;
	
	public CustomerController(CustomerService customerService)
	{
		this.customerService=customerService;
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<Object> registerCustomer(@Valid @RequestBody CustomerDto customerDto)
	{
		  CustomerDto cutomer = customerService.addCutomer(customerDto);
		  if(cutomer!=null) 
		  {
			return  HandleResponse.generateResponse(HttpStatus.CREATED,true,"Customer Saved..", cutomer);						  
		  }
		  else
		  {
			  return  HandleResponse.generateResponse(HttpStatus.BAD_REQUEST,false,"Something Went Wrong",cutomer);						  
		  }  
		  }

	
	@GetMapping(value = "/get/{id}")
	@CircuitBreaker(  name = "findDep", fallbackMethod = "getOrderFallBack")
	//@Retry(name = "myretry",fallbackMethod = "getOrderFallBack")
	//@RateLimiter(name ="ratelime" ,fallbackMethod = "getOrderFallBack")
	public ResponseEntity<Object> getCustomerById(@PathVariable String id)
	{
		Optional<CustomerDto> getCutomerById = customerService.GetCutomerById(id);
		CustomerDto customerDto = getCutomerById.get();
		return HandleResponse.generateResponse(HttpStatus.OK, true, "Customer Info", customerDto);
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<Object> getAllCustomer()
	{
		  List<CustomerDto> getAllCustomer = customerService.GetAllCustomer();
		  return HandleResponse.generateResponse(HttpStatus.OK, true, "Customer Info", getAllCustomer);
	}
	
	

public  ResponseEntity<Object> getOrderFallBack(String custId,Exception exception)
{
CustomerDto customerDto=new CustomerDto();
customerDto.setName("test");
customerDto.setEmail("test@gmail.com");
customerDto.setMobile("111111111");
customerDto.setId("12222");
Order list=new Order();
list.setOrderName("kuchnahe");
list.setOrderPrice("0.0");
list.setOrderId("111");
customerDto.setOrder(list);
 return HandleResponse.generateResponse(HttpStatus.BAD_GATEWAY,false, "Order Service Down hai", customerDto);		
}

	

 
	
	
	
	
}
