package com.banking.customer.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerUpdateRequest {

    @NotBlank(message = "First Name is Required")
    @Size(max = 100)
    private String firstName;

    @NotBlank(message = "Last Name is Required")
    @Size(max=100)
    private  String lastName;

    @NotBlank(message = "Phone Number is Required")
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must contain exactly 10 digits"
    )
    private String phoneNumber;


}
