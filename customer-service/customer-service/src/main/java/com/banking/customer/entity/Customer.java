package com.banking.customer.entity;

import com.banking.customer.enums.CustomerStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;


    @Column (name = "customer_number",nullable = false, unique = true, length = 20)
    private String customerNumber;

    @Column(name = "first_name",nullable = false,length = 100)
    private String firstName;

    @Column(name="last_name",nullable = false,length = 100)
    private String lastName;

    @Column(name = "email",nullable = false, unique = true,length = 150)
    @Email
    private String email;

    @Column(name = "phone_number",nullable = false,length = 20)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 30)
    private CustomerStatus status;

    @Column(name = "created_at",nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
