package com.example.RESTAPI;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RESTAPI.Products;
import com.example.RESTAPI.Productservice;

@RestController
@RequestMapping("/products")
public class Productcontrol {
	
	@Autowired
    Productservice productService;

    @GetMapping("/")
    public List<Products> list() {
        return productService.listAllUser();
    }
    
   
   @GetMapping("/search/{id}")
    public ResponseEntity<Products> get(@PathVariable int id) {
        try {
            Products product = productService.get(id);
            return new ResponseEntity<Products>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Products>(HttpStatus.NOT_FOUND);
        }      
    }
  
}
