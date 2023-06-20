package com.example.mySurferApplication.DemoApplication.Services;

import com.example.mySurferApplication.DemoApplication.Repositories.ContestRepository;
import com.example.mySurferApplication.DemoApplication.Repositories.SurferRepository;
import com.example.mySurferApplication.DemoApplication.Services.Entities.Contest;
import com.example.mySurferApplication.DemoApplication.Services.Entities.Surfer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ContestServiceTest {
    @Mock
    ContestRepository mockedContestRepository;
    @Mock
    SurferRepository mockedSurferRepository;
    private ContestService contestService;
    private Contest contest;
    private Surfer s;
    private Surfer s2;
    private Surfer s3;
    private Set<Surfer> surfers;
    @BeforeEach
    void setup(){
        contestService = new ContestService(mockedSurferRepository, mockedContestRepository);
        contest = new Contest("Lucerne", 2);
        contest.setId(3L);
        s = createSurfer("f", "Luzia", 1L);
        s2 = createSurfer("m", "Leon", 2L);
        s3 = createSurfer("m", "Zuon", 4L);
        surfers = new HashSet<>();

    }
    @Test
    void whenRegisterASurfer_andContestIsFull_thenRuntimeException(){
        surfers.add(s);
        surfers.add(s2);
        contest.setRegisteredSurfers(surfers);
        when(mockedContestRepository.findById(any())).thenReturn(Optional.of(contest));
        RuntimeException e = assertThrows(
                RuntimeException.class,
                () -> contestService.registerSurferAtContest(4L,3L)
        );
        assertTrue(contest.isFull());
        assertEquals("Max nr of surfer exceeded", e.getMessage());

    }
    @Test
    void whenRegisterASurfer_andContestIsNotFull_thenSurferRegistered(){
        surfers.add(s);
        surfers.add(s2);
        contest.setRegisteredSurfers(surfers);
        contest.setMaxNrOfSurfer(5);

        when(mockedContestRepository.findById(any())).thenReturn(Optional.of(contest));
        when(mockedContestRepository.save(contest)).thenReturn(contest);
        when(mockedSurferRepository.findById(any())).thenReturn(Optional.of(s3));

        contestService.registerSurferAtContest(4L,3L);

        assertEquals(3,contest.getRegisteredSurfers().size());
        assertTrue(contest.getRegisteredSurfers().contains(s3));
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

