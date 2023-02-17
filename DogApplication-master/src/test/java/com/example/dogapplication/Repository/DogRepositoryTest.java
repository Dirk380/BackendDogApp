package com.example.dogapplication.Repository;

import com.example.dogapplication.Model.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
class DogRepositoryTest {

    @Autowired
    private DogRepository dogRepositoryTest;

    @Test
    void itShouldCheckIfDogExistByName() {
        //given
        String silas = "Silas";
        Dog dog = new Dog(1L,
                silas,
                13 ,
                "Malinous",
                "Male",
                "Brown");
        //when
        dogRepositoryTest.save(dog);

        boolean exist = dogRepositoryTest.checkDogName(silas);
        //then
        assertThat(exist).isTrue();

    }
}