package com.skip.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.skip.entity.Customer;
import com.skip.entity.Order;
import com.skip.entity.Product;
import com.skip.service.IOrderService;

@Controller
@RequestMapping("api/v1")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	
	@GetMapping("Order/customer")
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> list = orderService.getAllOrders();
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}
	
	@GetMapping("Order/{orderId}")
	public ResponseEntity<Order> getProductById(@PathVariable("id") int id) {
		Order ord = orderService.getOrderById(id);
		return new ResponseEntity<Order>(ord, HttpStatus.OK);
	}
	
	@PostMapping("Order")
	public ResponseEntity<Void> addArticle(@RequestBody Order order, UriComponentsBuilder builder) {
        boolean flag = orderService.addOrder(order);
		if (flag) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
    	    return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
	}
}
