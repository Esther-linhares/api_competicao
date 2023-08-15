package apicompeticao.api.controllers;

import apicompeticao.api.dtos.CreateCategory;
import apicompeticao.api.dtos.ErrorData;
import apicompeticao.api.models.Athlete;
import apicompeticao.api.models.Category;
import apicompeticao.api.models.Club;
import apicompeticao.api.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categorys")
public class CategoryController {
    @Autowired
    public CategoryRepository repository;

    @GetMapping
    public ResponseEntity getAllCattegorys(){
        List<Category> categoryList = this.repository.findAll();
        return ResponseEntity.ok().body(categoryList);
    }
    @PostMapping
    @Transactional
    public ResponseEntity createCategory (@RequestBody CreateCategory newCategory){
        if(this.repository.existsByName(newCategory.name())){
            return ResponseEntity.badRequest().body((new ErrorData("Name","Categoria já cadastrado!")));
        } else {
            Category category = new Category(newCategory.name(), newCategory.age_min(), newCategory.age_max(), newCategory.gender());
            this.repository.save(category);
            return ResponseEntity.ok().body("Categoria cadastrado com sucesso");
        }
    }
    @DeleteMapping({"/{id}"})
    public ResponseEntity deleteAthlete(@PathVariable UUID id){
        Category category = repository.getById(id);
        if(category == null){
            return ResponseEntity.badRequest().body((new ErrorData("id","Categoria não encontrado!")));
        }
        repository.delete(category);
        return ResponseEntity.ok().body("Categoria apagada!");
    }
}
