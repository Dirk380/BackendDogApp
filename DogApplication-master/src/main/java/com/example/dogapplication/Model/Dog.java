package com.example.dogapplication.Model;

import javax.persistence.*;

@Entity
@Table(name = "Dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDs")
    private Long dogId;
    @Column(name = "DogName")
    private String dogName;
    @Column(name = "Ages")
    private int dogAge;
    @Column(name = "Races")
    private String dogRace;
    @Column(name = "Genders")
    private String dogGender;
    @Column(name = "Colors")
    private String dogColor;

    public Dog(Long dogId, String dogName, int dogAge, String dogRace, String dogGender, String dogColor) {
        this.dogId = dogId;
        this.dogName = dogName;
        this.dogAge = dogAge;
        this.dogRace = dogRace;
        this.dogGender = dogGender;
        this.dogColor = dogColor;
    }

    public Dog() {
    }

    public Long getDogId() {
        return dogId;
    }

    public void setDogId(Long dogId) {
        this.dogId = dogId;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public int getDogAge() {
        return dogAge;
    }

    public void setDogAge(int dogAge) {
        this.dogAge = dogAge;
    }

    public String getDogRace() {
        return dogRace;
    }

    public void setDogRace(String dogRace) {
        this.dogRace = dogRace;
    }

    public String getDogGender() {
        return dogGender;
    }

    public void setDogGender(String dogGender) {
        this.dogGender = dogGender;
    }

    public String getDogColor() {
        return dogColor;
    }

    public void setDogColor(String dogColor) {
        this.dogColor = dogColor;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dogId=" + dogId +
                ", dogName='" + dogName + '\'' +
                ", dogAge=" + dogAge +
                ", dogRace='" + dogRace + '\'' +
                ", dogGender='" + dogGender + '\'' +
                ", dogColor='" + dogColor + '\'' +
                '}';
    }
}
