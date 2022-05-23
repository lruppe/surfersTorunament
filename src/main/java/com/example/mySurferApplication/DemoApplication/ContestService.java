package com.example.mySurferApplication.DemoApplication;

import com.example.mySurferApplication.DemoApplication.Repositories.ContestRepository;
import com.example.mySurferApplication.DemoApplication.Repositories.SurferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
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

    public Surfer createSurfer (Surfer surfer) {
        //entityManager.persist(surfer);
        surferRepository.save(surfer);
        return surfer;
    }



    public Contest registerSurferAtContest(Long surferId, Long contestId) {
        Surfer surfer = surferRepository.findById(surferId).orElseThrow();
        //Surfer surfer = surferRepository.findById(surferId).orElseThrow(new IllegalArgumentException());

        Contest contest = contestRepository.findById(contestId).orElseThrow();

        //register
        contest.registerSurfer(surfer);
        contestRepository.save(contest);

        return contest;
    }

    public Surfer getSurfers(Long id) {
        Optional<Surfer> optSurfer = surferRepository.findById(id);
        if(optSurfer.isPresent()){
            return optSurfer.get();
        } else {
            throw new RuntimeException("Failed to find surfer for id " + id );
        }
        //return entityManager.find(Surfer.class, id);
    }

    public Contest getContest(Long id) {
        return contestRepository.findById(id).orElseThrow();
    }


}
