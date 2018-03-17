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

import com.skip.entity.Product;
import com.skip.service.IProductService;

@Controller
@RequestMapping("api/v1")
public class ProductController {
	@Autowired
	private IProductService productService;
	
	@GetMapping("Product")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> list = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	@GetMapping("Product/search/{searchText}")
	public ResponseEntity<List<Product>> getProductById(@PathVariable("searchText") String searchText) {
		List<Product> list = productService.searchText(searchText);
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	@GetMapping("Product/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") int id) {
		Product prod = productService.getProductById(id);
		return new ResponseEntity<Product>(prod, HttpStatus.OK);
	}
}
