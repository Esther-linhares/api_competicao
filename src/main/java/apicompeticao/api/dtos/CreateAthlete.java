package apicompeticao.api.dtos;

import apicompeticao.api.enums.Gender;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CreateAthlete(@NotBlank String name, @NotBlank String CPF, @NotBlank int age, @NotBlank Gender gender, @NotBlank UUID club_id, @NotBlank UUID category_id) {
     public CreateAthlete(@NotBlank String name, @NotBlank String CPF, @NotBlank int age, @NotBlank Gender gender, @NotBlank UUID club_id, @NotBlank UUID category_id){
          this.CPF = CPF;
          this.name = name;
          this.age = age;
          this.gender = gender;
          this.club_id = club_id;
          this.category_id = category_id;

     }
}
