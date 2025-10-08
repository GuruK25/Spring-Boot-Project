package com.project.api_e_commerce.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @Size(min = 3, max = 30, message = "Name should be between 3-30 characters")
    private String name;
    @NotEmpty(message = "Email is Required")
    @Email(message = "Email should be proper")
    private String email;
    @Pattern(regexp =  "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password should contain one uppercase lowercase special character and number and min 8 digits")
    private String password;
    @DecimalMin(value = "6000000000", message = "Enter proper Mobile Number")
    @DecimalMax(value = "999999999", message = "Enter proper Mobile Number")
    private Long mobile;
    @NotEmpty
    private String role;
}
