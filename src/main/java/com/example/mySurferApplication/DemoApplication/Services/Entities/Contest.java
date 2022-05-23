package com.example.mySurferApplication.DemoApplication.Services.Entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Contest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String place;
    @Column
    private Integer maxNrOfSurfer;

    @OneToMany()
    private Set<Surfer> registeredSurfers;

    public Contest(String place, Integer nrOfSurfer) {
        this.place = place;
        this.maxNrOfSurfer = nrOfSurfer;
        this.registeredSurfers = new HashSet<>();
    }

    public Contest(){};

    public Set<Surfer> registerSurfer(Surfer surfer) {
        if (registeredSurfers.size() == maxNrOfSurfer) {
            throw new RuntimeException("Max nr of surfer exceeded");
        }
        registeredSurfers.add(surfer);
        return registeredSurfers;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getMaxNrOfSurfer() {
        return maxNrOfSurfer;
    }

    public void setMaxNrOfSurfer(Integer maxNrOfSurfer) {
        this.maxNrOfSurfer = maxNrOfSurfer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Surfer> getRegisteredSurfers() {
        return registeredSurfers;
    }

    public void setRegisteredSurfers(Set<Surfer> registeredSurfers) {
        this.registeredSurfers = registeredSurfers;
    }
}
