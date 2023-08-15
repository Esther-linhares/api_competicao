package apicompeticao.api.models;

import apicompeticao.api.enums.Gender;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID category_id;
    @Column(name = "name_category")
    private String name;
    private int age_min;
    private int age_max;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Category(String name, int age_min, int age_max, Gender gender) {
        this.name = name;
        this.age_min = age_min;
        this.age_max = age_max;
        this.gender = gender;
    }
}
