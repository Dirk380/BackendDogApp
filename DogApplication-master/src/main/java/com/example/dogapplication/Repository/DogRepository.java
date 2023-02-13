package com.example.dogapplication.Repository;

import com.example.dogapplication.Model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface DogRepository extends JpaRepository <Dog, Long> {

    Boolean existsDogByDogId (Long dogId);

    @Query("" +
    "SELECT CASE WHEN COUNT(s) > 0 THEN " +
    "TRUE ELSE FALSE END " +
    "FROM Dog s " +
    "WHERE s.dogName = ?1"
    )
    Boolean checkDogName(String dogName);
}
