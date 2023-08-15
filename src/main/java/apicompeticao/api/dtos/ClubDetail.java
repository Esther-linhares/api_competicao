package apicompeticao.api.dtos;

import apicompeticao.api.models.Club;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record ClubDetail(@NotBlank String name, @NotBlank String state, @NotBlank Date foundation_date) {
    public ClubDetail (Club C) {this(C.getName(), C.getState(), C.getFoundation_date());}
    public ClubDetail(String name, String state, Date foundation_date){
        this.name = name;
        this.state = state;
        this.foundation_date = foundation_date;
    }


}
