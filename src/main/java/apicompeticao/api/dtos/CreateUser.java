package apicompeticao.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record CreateUser(@NotBlank String email, @NotBlank String password) {
    public CreateUser(@NotBlank String email, @NotBlank String password){
        this.email = email;
        this.password = password;
    }
}
