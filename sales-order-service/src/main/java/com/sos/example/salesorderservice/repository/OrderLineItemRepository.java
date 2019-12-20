package com.sos.example.salesorderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sos.example.salesorderservice.model.OrderLineItem;

public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Long>{

}
