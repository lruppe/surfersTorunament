package com.example.mySurferApplication.DemoApplication.Services.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Surfer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String country;
    @Column
    private String gender;

    public boolean isMale(){
        if (gender.equals("m")){
            return true;
        }
        return false;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
}

