package com.alkemy.disney.dto.post;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailPostDto {
    @NotBlank
    private String subject;
    @NotBlank
    private String body;

    @NotBlank
    private String  addressee;
}
