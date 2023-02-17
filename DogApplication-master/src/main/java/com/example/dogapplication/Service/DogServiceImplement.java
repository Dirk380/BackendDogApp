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
    public Dog updateDog(Long dogId, Dog dog) throws IllegalArgumentException {
        Dog test = dogRepository.findById(dogId).orElseThrow(() -> new IllegalStateException("ID not found"));
        if (dog == null) {
            throw new IllegalArgumentException("dog cannot be null");
        }
        if (dog.getDogName() != null && !dog.getDogName().equals("")) {
            test.setDogName(dog.getDogName());
        }
        if (dog.getDogColor() != null && !dog.getDogColor().equals("")) {
            test.setDogColor(dog.getDogColor());
        }
        if (dog.getDogGender() != null && !dog.getDogGender().equals("")) {
            test.setDogGender(dog.getDogGender());
        }
        if (dog.getDogRace() != null && !dog.getDogRace().equals("")) {
            test.setDogRace(dog.getDogRace());
        }
        if (dog.getDogAge() >= 0 && dog.getDogAge() <= 30)
            test.setDogAge(dog.getDogAge());
        return dogRepository.save(test);
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

}
