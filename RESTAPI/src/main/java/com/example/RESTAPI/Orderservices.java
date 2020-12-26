package com.example.RESTAPI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RESTAPI.Orders;
import com.example.RESTAPI.OrderRepository;

@Service
public class Orderservices {
	
	
	@Autowired
	private OrderRepository OrderRepository;
	
	public Orders save(Orders orders) {
        return OrderRepository.save(orders);
    }
	
	public Orders get(int id) {
        return OrderRepository.findById(id).get();
    }
	public void delete(int id) {
        OrderRepository.deleteById(id);
	}

}
