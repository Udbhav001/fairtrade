package com.apex.fairtrade.investor.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InvestorDTO {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Email
    private String email;
    @NotEmpty
    @Size(min = 10, max = 10)
    private String phoneNumber;
    @NotNull
    private AccountType accountType;
    @NotEmpty
    private String userName;
}
