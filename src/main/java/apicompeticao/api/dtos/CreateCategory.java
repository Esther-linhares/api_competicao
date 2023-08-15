package apicompeticao.api.dtos;

import apicompeticao.api.enums.Gender;
import jakarta.validation.constraints.NotBlank;

public record CreateCategory(@NotBlank String name, @NotBlank int age_min, @NotBlank int age_max, @NotBlank Gender gender) {
    public CreateCategory(@NotBlank String name, @NotBlank int age_min, @NotBlank int age_max, @NotBlank Gender gender){
        this.name = name;
        this.age_min = age_min;
        this.age_max = age_max;
        this.gender = gender;
    }
}
