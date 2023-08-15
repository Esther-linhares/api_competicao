package apicompeticao.api.controllers;

import apicompeticao.api.dtos.CreateCategory;
import apicompeticao.api.dtos.CreateUser;
import apicompeticao.api.dtos.ErrorData;
import apicompeticao.api.models.Category;
import apicompeticao.api.models.User;
import apicompeticao.api.repositories.AthleteRepository;
import apicompeticao.api.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    public UserRepository repository;
    @PostMapping
    public ResponseEntity createUser (@RequestBody CreateUser newUser){
        if(this.repository.existsByEmail(newUser.email())){
            return ResponseEntity.badRequest().body((new ErrorData("email","Usuário já cadastrado!")));
        } else {
            User user = new User(newUser.email(), newUser.password());
            this.repository.save(user);
            return ResponseEntity.ok().body("Usuario cadastrado com sucesso");
        }
    }
}
