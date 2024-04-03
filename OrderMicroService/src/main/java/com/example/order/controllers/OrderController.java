package com.example.order.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.dto.OrderDto;
import com.example.order.service.OrderService;
import com.example.order.utils.HandleResponse;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="api/order")
public class OrderController {
	
	private OrderService orderService;
	
	public OrderController(OrderService orderService)
	{
	this.orderService=orderService;	
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<Object> addOrder(@Valid @RequestBody OrderDto dto)
	{
		OrderDto order = orderService.addOrder(dto);
		if(order!=null)
		return HandleResponse.generateResponse(HttpStatus.CREATED,true,"Order Placed..", order);
		else
		return HandleResponse.generateResponse(HttpStatus.BAD_REQUEST,false,"Order Not Placed..", order);		
	}
	
	@GetMapping(value = "/getOrder/{customerId}")
	public ResponseEntity<Object> getOrderByCutomer(@PathVariable String customerId)
	{
		
		OrderDto orderByCustomerId = orderService.getOrderByCustomerId(customerId);
		if(orderByCustomerId!=null)
		return HandleResponse.generateResponse(HttpStatus.OK,true,"Your Order Is.", orderByCustomerId);
		else
		return HandleResponse.generateResponse(HttpStatus.BAD_REQUEST,false,"Order Not Found..", orderByCustomerId);	
		 
	}
	
	
	@GetMapping(value = "/getAllOrder")
	public ResponseEntity<Object> getOrderByCutomer()
	{
		
		  List<OrderDto> orderByAllOrder = orderService.getOrderByAllOrder();
		if(orderByAllOrder!=null)
		return HandleResponse.generateResponse(HttpStatus.OK,true,"Your Order Is.", orderByAllOrder);
		else
		return HandleResponse.generateResponse(HttpStatus.BAD_REQUEST,false,"Order Not Found..", orderByAllOrder);	
		 
	}
	
	

}
