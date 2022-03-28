package com.edu.ordermicroservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.ordermicroservice.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
