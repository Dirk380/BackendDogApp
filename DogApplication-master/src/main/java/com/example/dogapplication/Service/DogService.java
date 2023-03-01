package com.example.dogapplication.Service;

import com.example.dogapplication.Model.*;

import java.util.*;

public interface DogService {

    Dog addDog(Dog dog);

    void deleteDogById(Long dogId);
    void deleteAllDogs();
    void deleteDog(Dog dog);
    List<Dog> getAllDogs();
    Dog updateDog  (Dog dog) throws IllegalArgumentException;
}
