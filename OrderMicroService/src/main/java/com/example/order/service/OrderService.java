package com.example.order.service;

import java.util.List;

import com.example.order.dto.OrderDto;
 

public interface OrderService {

	public OrderDto addOrder(OrderDto order);
	
	public OrderDto getOrderByCustomerId(String  customerId);
	
	public List<OrderDto> getOrderByAllOrder();
	
	
	
}
