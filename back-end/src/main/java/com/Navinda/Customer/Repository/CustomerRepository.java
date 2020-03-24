package com.Navinda.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Navinda.Customer.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
