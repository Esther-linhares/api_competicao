package apicompeticao.api.controllers;

import apicompeticao.api.dtos.AthleteDetail;
import apicompeticao.api.dtos.CreateAthlete;
import apicompeticao.api.dtos.ErrorData;
import apicompeticao.api.enums.Gender;
import apicompeticao.api.models.Athlete;
import apicompeticao.api.models.Category;
import apicompeticao.api.models.Club;
import apicompeticao.api.repositories.AthleteRepository;
import apicompeticao.api.repositories.CategoryRepository;
import apicompeticao.api.repositories.ClubRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/athletes")
public class AthleteController {
    @Autowired
    public AthleteRepository repository;
    @Autowired
    public  ClubRepository ClubRepository;
    @Autowired
    public CategoryRepository CategoryRepository;
    @GetMapping
    public ResponseEntity getAllAthletes(){
        List<Athlete> athleteList = this.repository.findAll();
        return ResponseEntity.ok().body(athleteList);
    }
    @PostMapping
    @Transactional
    public ResponseEntity createAthleta(@RequestBody CreateAthlete newAthlete){
        var category = CategoryRepository.getById(newAthlete.category_id());
        if(repository.existsByCPF(newAthlete.CPF())){
            return ResponseEntity.badRequest().body((new ErrorData("CPF","Atleta já cadastrado!")));
        }
        if(!ClubRepository.existsById(newAthlete.club_id())){
            return ResponseEntity.badRequest().body((new ErrorData("club_id","Club não cadastrado!")));
        }
        if(!CategoryRepository.existsById(newAthlete.category_id())){
            return ResponseEntity.badRequest().body((new ErrorData("category_id","Categoria não cadastrado!")));
        }
        if(newAthlete.age() < category.getAge_min() || newAthlete.age() > category.getAge_max()){
            return ResponseEntity.badRequest().body((new ErrorData("age","Idade não permitida na categoria")));
        }
            Athlete athlete = new Athlete(newAthlete.CPF(), newAthlete.age(),newAthlete.name(),newAthlete.gender(),newAthlete.club_id(),newAthlete.category_id());
            repository.save(athlete);
            return ResponseEntity.ok().body("Atleta cadastrado com sucesso");

    };

    @DeleteMapping({"/{CPF}"})
    public ResponseEntity deleteAthlete(@PathVariable String CPF){
        Athlete athlete = repository.getByCPF(CPF);
        if(athlete == null){
            return ResponseEntity.badRequest().body((new ErrorData("CPF","Atleta não encontrado!")));
        }
        repository.delete(athlete);
        return ResponseEntity.ok().body("Atleta desclassificado");
    }

    @GetMapping({"/{club_id}/club"})
    public ResponseEntity getAthleteByClub(@PathVariable UUID club_id){
        if(!ClubRepository.existsById(club_id)){
            return ResponseEntity.badRequest().body((new ErrorData("club_id","club não encontrado!")));
        }
            List<Athlete> AllAthlete = this.repository.findAll();
            var AthleteByClub = AllAthlete.stream().filter(athlete -> athlete.getClub_id().equals(club_id));
            return ResponseEntity.ok().body(AthleteByClub);
    }
    @GetMapping({"/{category_id}/category"})
    public ResponseEntity getAthleteByCategory(@PathVariable UUID category_id){
        if(!CategoryRepository.existsById(category_id)){
            return ResponseEntity.badRequest().body((new ErrorData("category_id","Categoria não encontrado!")));
        }
        List<Athlete> AllAthlete = this.repository.findAll();
        var getAthleteByCategory = AllAthlete.stream().filter(athlete -> athlete.getCategory_id().equals(category_id));
        return ResponseEntity.ok().body(getAthleteByCategory);
    }

}
