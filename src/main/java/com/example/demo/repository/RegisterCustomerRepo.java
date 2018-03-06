package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.model.RegisterCustomer;


public interface RegisterCustomerRepo extends JpaRepository<RegisterCustomer, Long>,JpaSpecificationExecutor<RegisterCustomer> {

}
