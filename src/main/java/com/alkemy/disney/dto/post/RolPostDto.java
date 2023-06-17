package com.alkemy.disney.dto.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RolPostDto {

    private Long id;

    @NotBlank(message = "The field rolName cannot be empty ")
    @Size(min = 4, message = "Field must be longer than 3 characters")
    private String rolName;
}
