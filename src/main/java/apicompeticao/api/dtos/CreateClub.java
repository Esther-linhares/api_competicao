package apicompeticao.api.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record CreateClub(@NotBlank String name, @NotBlank String state, @NotBlank Date foundation_date) {
    public CreateClub(@NotBlank String name, @NotBlank String state, @NotBlank Date foundation_date){
        this.name = name;
        this.state = state;
        this.foundation_date = foundation_date;
    }
}
