package apicompeticao.api.repositories;

import apicompeticao.api.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClubRepository extends JpaRepository<Club, UUID> {
    Boolean existsByName(String name);
}
