package com.example.mySurferApplication.DemoApplication.Services.Entities;


import java.util.Set;

public class ContestDto {

    private Long id;

    private String place;

    private Integer maxParticipants;

    public Set<SurferDto> getRegisteredSurfers() {
        return registeredSurfers;
    }

    public void setRegisteredSurfers(Set<SurferDto> registeredSurfers) {
        this.registeredSurfers = registeredSurfers;
    }

    //@Question: DTO still returns the entity?
    private Set<SurferDto> registeredSurfers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(Integer maxParticipants) {
        this.maxParticipants = maxParticipants;
    }




}
