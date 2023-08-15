package apicompeticao.api.repositories;

import apicompeticao.api.models.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AthleteRepository extends JpaRepository<Athlete, String> {
    Boolean existsByCPF(String CPF);

    Athlete getByCPF(String CPF);
//    List<Athlete> findByClub(UUID club_id);

}
