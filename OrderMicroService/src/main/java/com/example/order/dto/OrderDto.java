package com.example.order.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
     
	
	private String orderId;
	
	@NotEmpty(message = "orderName is Required")
	@Size(min = 3,max = 50, message = "orderName Must be Bteween 3 to 50")
	private String orderName;
	
	@NotEmpty(message = "ordeQty is Required")
	@Size(min = 3,max = 10, message = "ordeQty Must be Bteween 3 to 10")
	private String ordeQty;
	
	@NotEmpty(message = "orderPrice is Required")
	@Size(min = 3,max = 100000, message = "orderPrice Must be Bteween 3 to 100000")
	private String orderPrice;

	@NotEmpty(message = "customerId is Required")
	@Size(min = 3,max = 50, message = "customerId Must be Bteween 10 to 100")
	private String customerId;

}
