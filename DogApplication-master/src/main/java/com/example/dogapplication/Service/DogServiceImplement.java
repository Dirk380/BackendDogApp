package com.example.dogapplication.Service;

import com.example.dogapplication.Model.*;
import com.example.dogapplication.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class DogServiceImplement implements DogService {

    private final DogRepository dogRepository;


    @Override
    public Dog addDog(Dog dog) {
        if (dog.getDogName() == null) {
            throw new IllegalArgumentException("Dog Name Should not be empty");
        }
        return dogRepository.save(dog);
    }

    @Override
    public void deleteDogById(Long dogId) {
        dogRepository.deleteById(dogId);

    }

    @Override
    public void deleteDog(Dog dog) {
        dogRepository.delete(dog);
    }

    @Override
    public void deleteAllDogs() {
        dogRepository.deleteAll();
    }

    @Override
    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    @Override
    public Dog updateDog(Dog dog) {
          return dogRepository.save(dog);
    }



}
