package com.example.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.order.entites.Order;
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, String>
{

	 Order findByCustomerId(String customerId);
}
