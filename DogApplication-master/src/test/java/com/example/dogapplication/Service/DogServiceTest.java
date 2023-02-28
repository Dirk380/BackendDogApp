package com.example.dogapplication.Service;

import com.example.dogapplication.Model.Dog;
import com.example.dogapplication.Repository.DogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DogServiceTest {

    @Mock
    private DogRepository dogRepository;
    private DogServiceImplement dogServiceTest;


    @BeforeEach
    void setUp() {
        dogServiceTest = new DogServiceImplement(dogRepository);
    }

    @Test
    void getAllDogs() {
        //when
        dogServiceTest.getAllDogs();
        //then
        verify(dogRepository).findAll();
    }

    @Test
    void canAddDog() {
        //given
        Dog dog = new Dog(1L,
                "silas",
                13 ,
                "Malinous",
                "Male",
                "Brown");
        //when
        dogServiceTest.addDog(dog);
        //then
        ArgumentCaptor<Dog> dogArgumentCaptor = ArgumentCaptor.forClass(Dog.class);

        verify(dogRepository).save(dogArgumentCaptor.capture());

        Dog captorValue = dogArgumentCaptor.getValue();
        assertThat(captorValue).isEqualTo(dog);
    }



    @Test
    void willThrowWhenNameIsEmpty() {
        //given
        Dog dog = new Dog(1L,
                null,
                13 ,
                "Malinous",
                "Male",
                "Brown");
        //when
        //then
        assertThatThrownBy(()->dogServiceTest.addDog(dog))
                .hasMessageContaining("Dog Name Should not be empty");

        verify(dogRepository, never()).save(any());
    }

    @Test
    @Disabled
    void updateDog() {
    }


    @Test
    void canDeleteDog() {
        //given
        Dog dog = new Dog(1L,
                "silas",
                13 ,
                "Malinous",
                "Male",
                "Brown");
        //when
        dogServiceTest.deleteDog(dog);
        //then
        ArgumentCaptor<Dog> dogArgumentCaptor = ArgumentCaptor.forClass(Dog.class);
        verify(dogRepository).delete(dogArgumentCaptor.capture());

        Dog captorValue = dogArgumentCaptor.getValue();
        assertThat(captorValue).isEqualTo(dog);
    }

    @Test
    void canDeleteAllDogs(){
        //given
        Dog dog = new Dog(1L,
                "silas",
                13 ,
                "Malinous",
                "Male",
                "Brown");
        //when
        dogRepository.deleteAll();
        //then
        ArgumentCaptor<Dog> dogArgumentCaptor = ArgumentCaptor.forClass(Dog.class);
        verify(dogRepository).delete(dogArgumentCaptor.capture());

        Dog captorValue = dogArgumentCaptor.getValue();
        assertThat(captorValue).isEqualTo(dog);
    }




}