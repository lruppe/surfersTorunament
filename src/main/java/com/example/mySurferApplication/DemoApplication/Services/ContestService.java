package com.example.mySurferApplication.DemoApplication.Services;

import com.example.mySurferApplication.DemoApplication.Repositories.ContestRepository;
import com.example.mySurferApplication.DemoApplication.Repositories.SurferRepository;
import com.example.mySurferApplication.DemoApplication.Services.Entities.Contest;
import com.example.mySurferApplication.DemoApplication.Services.Entities.Surfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContestService {

    @Autowired
    private SurferRepository surferRepository;
    @Autowired
    private ContestRepository contestRepository;

    public Contest createContest(String place, Integer nrOfSurfer) {
        Contest contest = new Contest(place, nrOfSurfer);
        //entityManager.persist(contest);
        contestRepository.save(contest);
        return contest;
    }

    public Contest getContest(Long id) {
        return contestRepository.findById(id).orElseThrow();
    }

    public Contest registerSurferAtContest(Long surferId, Long contestId) {
        Surfer surfer = surferRepository.findById(surferId).orElseThrow();
        Contest contest = contestRepository.findById(contestId).orElseThrow();
        //Surfer surfer = surferRepository.findById(surferId).orElseThrow(new IllegalArgumentException());

        if (contest.getRegisteredSurfers().size() == contest.getMaxNrOfSurfer()) {
            throw new RuntimeException("Max nr of surfer exceeded");
        }

        //register
        contest.registerSurfer(surfer);
        contestRepository.save(contest);

        return contest;
    }


}
