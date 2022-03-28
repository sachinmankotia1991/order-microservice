package com.edu.ordermicroservice.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.ordermicroservice.model.Order;
import com.edu.ordermicroservice.repo.OrderRepo;

@RestController
public class OrderResource {
	private final static Logger LOG = LoggerFactory.getLogger(OrderResource.class);
	@Autowired
	private OrderRepo repo;

	// Method to get all orders present in DB
	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		LOG.info("inside getAllOrders method");
		return repo.findAll();
	}

	@GetMapping("/order/{orderid}")
	public ResponseEntity<Order> getOrderById(@PathVariable("orderid") int id) {
		LOG.info("inside getOrderById method");
		return new ResponseEntity<Order>(repo.getById(id), HttpStatus.OK);
	}

	// Method to create a new order
	@PostMapping("/orders")
	public ResponseEntity<Order> saveUser(@RequestBody Order order) throws Exception {
		LOG.info("inside saveUser method");
		return new ResponseEntity<Order>(repo.save(order), HttpStatus.CREATED);

	}

}
