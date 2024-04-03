package com.example.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
private String orderId;
private String orderName;
private String ordeQty;
private String orderPrice;
private String customerId;


}
