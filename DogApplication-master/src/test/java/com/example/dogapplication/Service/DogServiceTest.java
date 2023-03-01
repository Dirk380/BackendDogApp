package com.example.dogapplication.Service;

import com.example.dogapplication.Model.Dog;
import com.example.dogapplication.Repository.DogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DogServiceTest {

    @Mock
    private DogRepository dogRepositoryMock;
    @InjectMocks
    private DogServiceImplement dogServiceTest;


    @BeforeEach
    void setUp() {
        dogServiceTest = new DogServiceImplement(dogRepositoryMock);
        Dog dog = new Dog(1L,
                "silas",
                13,
                "Malinous",
                "Male",
                "Brown");
    }

    @Test
    void getAllDogs() {
        //when
        dogServiceTest.getAllDogs();
        //then
        verify(dogRepositoryMock).findAll();
    }

    @Test
    void canAddDog() {
        //given
        Dog dog = new Dog(1L,
                "silas",
                13,
                "Malinous",
                "Male",
                "Brown");
        //when
        dogServiceTest.addDog(dog);
        //then
        ArgumentCaptor<Dog> dogArgumentCaptor = ArgumentCaptor.forClass(Dog.class);

        verify(dogRepositoryMock).save(dogArgumentCaptor.capture());

        Dog captorValue = dogArgumentCaptor.getValue();
        assertThat(captorValue).isEqualTo(dog);
    }



    @Test
    void updateDog() {
        //given
        Dog dog = new Dog(1L,
                "silas",
                13,
                "Malinous",
                "Male",
                "Brown");

        Dog newDog = new Dog(1L,
                "Kobus",
                13,
                "Boerboel",
                "Male",
                "Brown");

        //when

        dogServiceTest.updateDog(dog);
        ArgumentCaptor<Dog> dogArgumentCaptor = ArgumentCaptor.forClass(Dog.class);
        verify(dogRepositoryMock).save(dogArgumentCaptor.capture());

        //then
        Dog captorDog = dogArgumentCaptor.getValue();
        assertThat(captorDog).isEqualTo(dog);
    }



    @Test
    void willThrowWhenNameIsEmpty() {
        //given
        Dog dog = new Dog(1L,
                null,
                13,
                "Malinous",
                "Male",
                "Brown");
        //when
        //then
        assertThatThrownBy(() -> dogServiceTest.addDog(dog))
                .hasMessageContaining("Dog Name Should not be empty");

        verify(dogRepositoryMock, never()).save(any());

    }


    @Test
    void canDeleteDog() {
        //given
        Dog dog = new Dog(1L,
                "silas",
                13,
                "Malinous",
                "Male",
                "Brown");
        //when
        dogServiceTest.deleteDog(dog);
        //then
        ArgumentCaptor<Dog> dogArgumentCaptor = ArgumentCaptor.forClass(Dog.class);
        verify(dogRepositoryMock).delete(dogArgumentCaptor.capture());

        Dog captorValue = dogArgumentCaptor.getValue();
        assertThat(captorValue).isEqualTo(dog);
    }

    @Test
    void canDeleteAllDogs() {
        //given
        Dog dog = new Dog(1L,
                "silas",
                13,
                "Malinous",
                "Male",
                "Brown");

        Dog dog2 = new Dog(1L,
                "silas",
                13,
                "Malinous",
                "Male",
                "Brown");
        //when
        dogServiceTest.deleteAllDogs();
        //then
        verify(dogRepositoryMock, times(1)).deleteAll();
    }

    @Test
    void canDeleteById(){
      Dog dog = new Dog();
      dog.setDogId(1L);

      dogServiceTest.deleteDogById(dog.getDogId());
      verify(dogRepositoryMock, times(1)).deleteById(1L);
    }


}