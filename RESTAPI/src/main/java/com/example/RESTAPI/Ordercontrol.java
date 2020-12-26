package com.example.RESTAPI;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RESTAPI.Orders;
import com.example.RESTAPI.Orderservices;

@RestController
@RequestMapping("/orders")
public class Ordercontrol {
	
	@Autowired
	private Orderservices Orderservices;
	
	

	//add the order
	@PostMapping(path="/add",consumes = "application/json") 
	 public Orders save(@RequestBody Orders Orders) {
		System.out.print("Your Order is Saved Successfully");
		Orderservices.save(Orders);
		return Orders;	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Orders order, @PathVariable Integer id) {
	    try {
	        Orders existProduct = Orderservices.get(id);
	        Orderservices.save(order);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@DeleteMapping("/orders/{id}")
	public void delete(@PathVariable Integer id) {
	    Orderservices.delete(id);
	}
	

}
