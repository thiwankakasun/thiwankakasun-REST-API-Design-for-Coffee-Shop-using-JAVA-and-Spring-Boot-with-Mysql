package com.example.RESTAPI;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RESTAPI.Products;



@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

	List<Products> findAll();

	Object findById(int id);

}

