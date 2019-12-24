package com.creditcard.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Setter
@Getter
@ToString
public class UserDto {

    private Long userId;
    @NotBlank(message = "Name should not be a blank")
    private String name;
    @NotBlank(message = "User name should not be a blank")
    private String userName;
    private String password;
    private Double salary;
    private Long mobileNumber;
    private LocalDate dob;
    private String address;
    private Long creditCardId;
}
