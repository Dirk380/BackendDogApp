package com.example.dogapplication.Repository;

import com.example.dogapplication.Model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface DogRepository extends JpaRepository <Dog, Long> {
    Dog findAllByDogRace (Dog dog);
}
