package apicompeticao.api.models;

import apicompeticao.api.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Setter
@Table(name = "athlete")
public class Athlete {
    @Id
    private String CPF;

    @Column(name = "name_athlete")
    private String name;


    @Column(name="age_athlete")
    private int  age;

    private Gender gender;

    private UUID club_id;

    private UUID category_id;

    public Athlete(String CPF, int age, String name, Gender gender, UUID club_id, UUID category_id) {
        this.CPF = CPF;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.club_id = club_id;
        this.category_id = category_id;
    }

    //    ver se é assim que usa
}
