package com.example.dogapplication.Service;

import com.example.dogapplication.Model.*;

import java.util.*;

public interface DogService {

    Dog addDog(Dog dog);

    Dog updateDog(Long dogId, Dog dog)throws IllegalArgumentException;

    void  deleteDog(Long dogId);
    void deleteAllDogs();
    List<Dog> getAllDogs();

}
