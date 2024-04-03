package com.example.order.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="order123")
public class Order {

@Id
@GeneratedValue(strategy = GenerationType.UUID)
private String orderId;

private String orderName;
private String ordeQty;
private String orderPrice;
private String customerId;


}
