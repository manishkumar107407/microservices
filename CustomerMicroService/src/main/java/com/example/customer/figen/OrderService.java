package com.example.customer.figen;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "orderservice", url = "http://localhost:8082/api/order")
public interface OrderService {
	@GetMapping(value = "/getOrder/{customerId}")
	public ResponseEntity<Object> getOrderByCutomer(@PathVariable String customerId);
	 
}
