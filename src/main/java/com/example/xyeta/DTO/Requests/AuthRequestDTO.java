package com.example.xyeta.DTO.Requests;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AuthRequestDTO {
    public String username;

    @NotBlank
    public String password;
}
