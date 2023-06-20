package com.example.mySurferApplication.DemoApplication.Services.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ContestTest {
    private Contest contest;
    private Surfer s;
    private Surfer s2;
    private Set<Surfer> surfers;

    @BeforeEach
    void setup(){
        contest = new Contest("Lucerne", 2);
        s = createSurfer("f", "Luzia", 1L);
        s2 = createSurfer("m", "Leon", 2L);
        surfers = new HashSet<>();

    }
    @Test
    void whenContestIsFull_isFullTrue() {
        surfers.add(s);
        surfers.add(s2);
        contest.setRegisteredSurfers(surfers);
        assertTrue(contest.isFull());
    }
    @Test
    void whenContestIsNotFull_isFullFalse() {
        surfers.add(s);
        contest.setRegisteredSurfers(surfers);
        assertFalse(contest.isFull());
    }

    private Surfer createSurfer (String gender, String name, Long id){
        var s = new Surfer();
        s.setGender(gender);
        s.setName(name);
        s.setId(id);
        s.setCountry("Switzerland");
        return s;
    }
}