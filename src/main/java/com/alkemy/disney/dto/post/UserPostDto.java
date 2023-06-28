package com.alkemy.disney.dto.post;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPostDto {

    @Min(message = "The identification must have a maximum of 15 characters.", value = 0L)
    private Long identification;

    @NotBlank
    @Size(max = 10, message = "The username must have a maximum of 10 characters.")
    private String username;

    @NotBlank
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotBlank
    @Email
    private String  email;
}
