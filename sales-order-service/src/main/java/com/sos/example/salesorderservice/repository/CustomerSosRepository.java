package com.sos.example.salesorderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sos.example.salesorderservice.model.CustomerSos;

public interface CustomerSosRepository extends JpaRepository<CustomerSos, Long>{

}
