package com.example.RESTAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RESTAPI.Products;
import com.example.RESTAPI.ProductRepository;

@Service
public class Productservice {
	
	@Autowired
	private ProductRepository ProductRepository;
	
	public List<Products> listAllUser() {
        return ProductRepository.findAll();
    }
	
	
	public Products get(int id) {
        return ProductRepository.findById(id).get();
    }
	
	     
	
	
	

}

