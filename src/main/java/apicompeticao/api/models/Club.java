package apicompeticao.api.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Table(name = "club")
public class Club {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID club_id;
    @Column(name = "name_club")
    private String name;
    private String state;
    private Date foundation_date;//ver sobre o date

    public Club(String name, String state, Date foundation_date) {
        this.name = name;
        this.state = state;
        this.foundation_date = foundation_date;
    }
}

