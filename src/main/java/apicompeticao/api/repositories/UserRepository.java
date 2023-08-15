package apicompeticao.api.repositories;

import apicompeticao.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByEmail(String email);
    Boolean existsByEmail(String email);
}
