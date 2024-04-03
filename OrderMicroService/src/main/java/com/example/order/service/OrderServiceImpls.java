package com.example.order.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.order.dto.OrderDto;
import com.example.order.entites.Order;
import com.example.order.repo.OrderRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderServiceImpls  implements OrderService
{

	private OrderRepo orderRepo;
	private ObjectMapper mapper;
	
	public OrderServiceImpls(OrderRepo orderRepo,ObjectMapper mapper)
	{
		this.orderRepo=orderRepo;
		this.mapper=mapper;
		
	}
	
	@Override
	public OrderDto addOrder(OrderDto order) {
		 Order order1 = mapper.convertValue(order, Order.class);
		 Order save = orderRepo.save(order1);	
		  OrderDto convertValue = mapper.convertValue(save, OrderDto.class);
		 return convertValue;
	}

	@Override
	public OrderDto getOrderByCustomerId(String customerId) {
		Order order = orderRepo.findByCustomerId(customerId);
		  OrderDto convertValue = mapper.convertValue(order, OrderDto.class);
		 return convertValue;
	}

	@Override
	public List<OrderDto> getOrderByAllOrder() {
		List<Order> all = orderRepo.findAll();
		  List<OrderDto> asList = Arrays.asList(mapper.convertValue(all, OrderDto[].class));
		return asList;
	}

}
