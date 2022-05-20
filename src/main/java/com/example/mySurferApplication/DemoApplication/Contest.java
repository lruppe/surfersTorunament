package com.example.mySurferApplication.DemoApplication;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contest {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String place;
    @Column
    private Integer maxNrOfSurfer;
    @Column
    private Integer currentNrOfSurfers;

    @OneToMany(mappedBy = "contest")
    private List<Surfer> registeredSurfers;
    public Contest(String place, Integer nrOfSurfer) {
        this.place = place;
        this.maxNrOfSurfer = nrOfSurfer;
        this.registeredSurfers = new ArrayList<>();
        this.currentNrOfSurfers = 0;
    }

    public Contest(){};

    public List<Surfer> registerSurfer(Surfer surfer) {
        if (currentNrOfSurfers == maxNrOfSurfer) {
            throw new RuntimeException("Max nr of surfer exceeded");
        }
        registeredSurfers.add(surfer);
        currentNrOfSurfers++;
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

    public List<Surfer> getRegisteredSurfers() {
        return registeredSurfers;
    }

    public Long getId() {
        return id;
    }

    public Integer getCurrentNrOfSurfers() {
        return currentNrOfSurfers;
    }
}
