package com.example.mySurferApplication.DemoApplication;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContestService {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public Contest createContest(String place, Integer nrOfSurfer) {
        Contest contest = new Contest(place, nrOfSurfer);
        entityManager.persist(contest);
        return contest;
    }

    @Transactional
    public Surfer createSurfer (Surfer surfer) {
        entityManager.persist(surfer);
        return surfer;
    }
    @Transactional
    public Surfer getSurfers(Long id) {
        return entityManager.find(Surfer.class, id);
    }

    @Transactional
    public Contest registerSurferAtContest(Long surferId, Long contestId) {
        Surfer surfer = entityManager.find(Surfer.class, surferId);
        if (surfer == null) {
            throw new RuntimeException("Failed to find surfer for id " + surferId);
        }
        Contest contest = entityManager.find(Contest.class, contestId);
        List<Surfer> surfers = contest.registerSurfer(surfer);
        for(Surfer s : surfers) {
            System.out.println(s.toString());
        }
        entityManager.persist(contest);
        return contest;
    }

    @Transactional
    public Contest getContest(Long id) {
        return entityManager.find(Contest.class, id);
    }


}
