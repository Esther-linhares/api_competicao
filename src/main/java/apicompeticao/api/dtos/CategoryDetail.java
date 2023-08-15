package apicompeticao.api.dtos;

import apicompeticao.api.enums.Gender;
import apicompeticao.api.models.Category;
import jakarta.validation.constraints.NotBlank;

public record CategoryDetail(@NotBlank String name, @NotBlank int age_min, @NotBlank int age_max, @NotBlank Gender gender) {
    public CategoryDetail(Category C) {this(C.getName(), C.getAge_min(),C.getAge_max(),C.getGender());}

    public CategoryDetail(String name, int age_min, int age_max, Gender gender){
        this.name = name;
        this.age_min = age_min;
        this.age_max = age_max;
        this.gender = gender;
    }
}
