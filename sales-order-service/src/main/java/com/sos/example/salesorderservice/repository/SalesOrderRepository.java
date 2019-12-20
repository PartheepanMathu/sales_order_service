package com.sos.example.salesorderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sos.example.salesorderservice.model.SalesOrder;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {

}
