package com.example.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.customer.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String>
{

}
