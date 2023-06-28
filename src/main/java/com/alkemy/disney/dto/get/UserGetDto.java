package com.alkemy.disney.dto.get;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserGetDto {

    private Long identification;
    private String  email;
    private String rolName;
}
