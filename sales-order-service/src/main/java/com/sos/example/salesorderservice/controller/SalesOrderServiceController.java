package com.sos.example.salesorderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sos.example.salesorderservice.model.CustomerSos;
import com.sos.example.salesorderservice.model.Order;
import com.sos.example.salesorderservice.repository.CustomerSosRepository;

@RestController
@RequestMapping(value="/service3")
public class SalesOrderServiceController {

	@Autowired
	private CustomerSosRepository customerSosRepository;
	
	@Autowired
	private SosService sosService;
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public CustomerSos  createCustomers(@RequestBody CustomerSos customer){
		CustomerSos newCustomer = customerSosRepository.save(customer);
		return newCustomer;
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public Order createOrder(@RequestBody Order order){
		System.out.println("Order id"+order.getCustId());
		System.out.println("Item 1"+order.getItems().get(0).getName());
		System.out.println("Item 2"+order.getItems().get(1).getName());
		System.out.println("Quantity"+order.getItems().get(1).getQuantity());
		boolean value = customerSosRepository.existsById(order.getCustId());
		System.out.println(value);
		if(value){
			sosService.createOrder(order);
		}
		return null;
	}
}
