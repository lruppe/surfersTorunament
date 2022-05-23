package com.example.mySurferApplication.DemoApplication.Services;

import com.example.mySurferApplication.DemoApplication.Repositories.SurferRepository;
import com.example.mySurferApplication.DemoApplication.Services.Entities.Surfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SurferService {
    @Autowired
    private SurferRepository surferRepository;


    public Surfer createSurfer (Surfer surfer) {
        //entityManager.persist(surfer);
        surferRepository.save(surfer);
        return surfer;
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

}
