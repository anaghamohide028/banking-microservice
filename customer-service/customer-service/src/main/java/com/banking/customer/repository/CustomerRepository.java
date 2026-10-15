package com.banking.customer.repository;

import com.banking.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    boolean existsByEmail(String email);

    Optional<Customer> findByEmail(String email);

    boolean existsByCustomerNumber(String customerNumber);

    Optional<Customer> findByCustomerNumber(String customerNumber);

}
