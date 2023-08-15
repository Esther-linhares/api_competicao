package apicompeticao.api.dtos;

import apicompeticao.api.models.Athlete;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

public record AthleteDetail(@NotBlank String name, @NotBlank String CPF, @NotBlank int age, @NotBlank UUID club_id, @NotBlank UUID category_id) {
    public AthleteDetail(Athlete a) {this(a.getName(),a.getCPF(),a.getAge(),a.getClub_id(),a.getCategory_id());}

    public AthleteDetail(String name,String CPF, int age, UUID club_id, UUID category_id){
        this.name = name;
        this.CPF = CPF;
        this.age = age;
        this.club_id = club_id;
        this.category_id = category_id;
    }


}
