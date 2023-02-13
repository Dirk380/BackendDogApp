package com.example.dogapplication.Repository;

import com.example.dogapplication.Model.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class DogRepositoryTest {

    @Autowired
    private DogRepository dogRepositoryTest;

    @Test
    void existsDogByDogId() {
    }

    @Test
    void itShouldCheckIfDogExistByName() {
        //given
        Dog dog = new Dog(1L, "Silas", 13 , "Malinous", "Male","Brown");
        //when

        //then
    }
}