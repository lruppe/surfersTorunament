package com.example.mySurferApplication.DemoApplication.Repositories;

import com.example.mySurferApplication.DemoApplication.Services.Entities.Surfer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SurferRepositoryTest {

    @Autowired
    private SurferRepository surferRepository;
    @BeforeEach
    void setUpData(){
        var s1 = createSurfer("m", "Leon", "Switzerland");
        var s2 = createSurfer("m", "Oliver", "Switzerland");
        var s3 = createSurfer("f", "Selina", "Switzerland");
        var s4 = createSurfer("m", "Blobb", "Switzerland");
        List<Surfer> surfers = new ArrayList<>(Arrays.asList(s1, s2, s3, s4));
        for (Surfer s : surfers){surferRepository.save(s);}
    }
    @Test
    void whenFindMaleSurferQuery_allMaleSurferReturned() {
        Collection<Surfer> surfers = surferRepository.findMaleSurfers();
        assertEquals(3,surfers.size());
    }
    private Surfer createSurfer (String gender, String name, String country){
        var s = new Surfer();
        s.setGender(gender);
        s.setName(name);
        s.setCountry(country);
        return s;
    }
}