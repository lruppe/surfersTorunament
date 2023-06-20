package com.example.mySurferApplication.DemoApplication.Services.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurferTest {
    private Surfer s;
    @BeforeEach
    void setup(){
        s = new Surfer();
        s.setGender("m");
        s.setName("Leon");
        s.setId(1L);
        s.setCountry("Switzerland");
    }
    @Test
    void whenM_thenIsMaleIsTrue() {
        assertTrue(s.isMale());
    }
    @Test
    void whenF_thenIsMaleIsFalse() {
        s.setGender("f");
        assertFalse(s.isMale());
    }

}