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
import com.skip.service.ICustomerService;

@Controller
@RequestMapping("api/v1")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	@PostMapping("Customer/auth")
	public ResponseEntity<?> verifyCustomerAuth(@RequestBody Customer customer, UriComponentsBuilder builder) {
		boolean flag = customerService.verifyCustomerAuth(customer.getEmail(),customer.getPassword());
		if (flag) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("error: User and Password not found.", HttpStatus.BAD_REQUEST);
        }
	}
	
	@PostMapping("Customer")
	public ResponseEntity<Void> addArticle(@RequestBody Customer article, UriComponentsBuilder builder) {
        boolean flag = customerService.addCustomer(article);
		if (flag) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
    	    return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
	}
	@GetMapping("Customer")
	public ResponseEntity<List<Customer>> getAllArticles() {
		List<Customer> list = customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}
}
