package apicompeticao.api.controllers;

import apicompeticao.api.dtos.CreateClub;
import apicompeticao.api.dtos.ErrorData;
import apicompeticao.api.models.Athlete;
import apicompeticao.api.models.Club;
import apicompeticao.api.repositories.ClubRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clubs")
public class ClubController {
    @Autowired
    public ClubRepository repository;

    @GetMapping
    public ResponseEntity getAllClubs(){
        List<Club> clubList = this.repository.findAll();
        return ResponseEntity.ok().body(clubList);
    }
    @PostMapping
    @Transactional
    public ResponseEntity createClub(@RequestBody CreateClub newClub){
        if(this.repository.existsByName(newClub.name())){
            return ResponseEntity.badRequest().body((new ErrorData("name","Clube já cadastrado!")));
        } else {
            Club club = new Club(newClub.name(), newClub.state(), newClub.foundation_date());
            this.repository.save(club);
            return ResponseEntity.ok().body("Club cadastrado com sucesso");
        }
    };

    @DeleteMapping({"/{id}"})
    public ResponseEntity deleteAthlete(@PathVariable UUID id){
        Club club = repository.getById(id);
        if(club == null){
            return ResponseEntity.badRequest().body((new ErrorData("id","Clube não encontrado!")));
        }
        repository.delete(club);
        return ResponseEntity.ok().body("Club desclassificado");
    }
}
