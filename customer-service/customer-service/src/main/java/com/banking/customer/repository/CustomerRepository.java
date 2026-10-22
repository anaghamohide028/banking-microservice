package com.banking.customer.repository;

import com.banking.customer.dto.response.CustomerResponse;
import com.banking.customer.entity.Customer;
import com.banking.customer.enums.CustomerStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    boolean existsByEmail(String email);

    Optional<Customer> findByEmail(String email);

    boolean existsByCustomerNumber(String customerNumber);

    Optional<Customer> findByCustomerNumber(String customerNumber);

    Page<Customer> findByStatus(CustomerStatus status, Pageable pageable);

}
