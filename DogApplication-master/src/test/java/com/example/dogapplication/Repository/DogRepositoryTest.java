package com.example.dogapplication.Repository;

import com.example.dogapplication.Model.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


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
        dogRepositoryTest.save(dog);

        boolean exist = dogRepositoryTest.checkDogName(dog.getDogName());
        //then
        assertThat(exist).isTrue();

    }
}