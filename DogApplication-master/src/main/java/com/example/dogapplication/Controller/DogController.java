package com.example.dogapplication.Controller;

import com.example.dogapplication.Model.*;
import com.example.dogapplication.Repository.DogRepository;
import com.example.dogapplication.Service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;




import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/Dog")
public class DogController {


    @Autowired
    private DogServiceImplement dogServiceImplement;

    @Autowired
    private DogRepository dogRepository;

    public DogController(DogServiceImplement dogServiceImplement) {
        this.dogServiceImplement = dogServiceImplement;
    }

    public DogController() {
    }

    @GetMapping("/getAll")
    public List<Dog> getDogs(){
       return dogServiceImplement.getAllDogs();
   }

    @GetMapping("/checkName/{dogName}")
    public  boolean checkDogName(@PathVariable String dogName ){
        return dogRepository.checkDogName(dogName);
    }

   @PostMapping("/add")
    public ResponseEntity<String> addDog(@RequestBody Dog dog){
       Dog newDog = dogServiceImplement.addDog(dog);
       return new ResponseEntity<>("New Dog is added", HttpStatus.OK);
   }

    @PutMapping("/{dogId}")
    public ResponseEntity<Dog> updateDog(@PathVariable Long dogId, @Valid @RequestBody Dog dog) {
        Dog testDog = dogServiceImplement.updateDog(dogId, dog);
        return ResponseEntity.ok(testDog);
    }

    //update controller claudia
    @PutMapping({"/update/{dogId}"})
    public Dog updateDog2(@RequestBody Dog dog, @PathVariable Long dogId) {
        return dogServiceImplement.updateDog(dogId, dog);
    }

    @DeleteMapping("/delete/{dogId}")
    public ResponseEntity<?> deleteDog(@PathVariable Long dogId) {
        dogServiceImplement.deleteDogById(dogId);
       return new ResponseEntity<>("Dog with id: " + dogId +" is deleted" , HttpStatus.OK);
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteAllDogs(){
        dogServiceImplement.deleteAllDogs();
        return new ResponseEntity<>("All dogs from database are deleted", HttpStatus.OK);
    }
}
