package com.mapstruct.mapstruct.model;

import com.mapstruct.mapstruct.PersonType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    @Valid
    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp="^[a-zA-Z0-9_\\-.]*$", message ="no caracteres raros" )
    private String name;

    @NotBlank(message = "Pass is mandatory")
    @Pattern(regexp="^[a-zA-Z0-9_\\-.]*$", message ="no caracteres raros" )
    private String pass;
}
