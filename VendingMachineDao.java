package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.product;
import com.example.demo.model.Product;



	@Repository
	public interface VendingMachineDao extends JpaRepository<Product,Integer>
	{

		List<product> findByCost(int coin);
	
	
}
