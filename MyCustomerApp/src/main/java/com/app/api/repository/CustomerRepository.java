package com.app.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.api.models.Customer;

/**
 * 
 * @author Rommel A. Suarez
 * This represents the data access layer.
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
