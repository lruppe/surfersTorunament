package com.example.mySurferApplication.DemoApplication.Services;

import com.example.mySurferApplication.DemoApplication.Mappers.SurferMapper;
import com.example.mySurferApplication.DemoApplication.Repositories.SurferRepository;
import com.example.mySurferApplication.DemoApplication.Services.Entities.Surfer;
import com.example.mySurferApplication.DemoApplication.Services.Entities.SurferDto;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SurferService {
    @Autowired
    private SurferRepository surferRepository;

    private SurferMapper surferMapper = Mappers.getMapper(SurferMapper.class);


    public SurferDto createSurfer (SurferDto surferDto) {
        //entityManager.persist(surfer);
        surferRepository.save(surferMapper.dtoToSurfer(surferDto));
        return surferDto;
    }

    public SurferDto getSurfers(Long id) {
        Optional<Surfer> optSurfer = surferRepository.findById(id);
        if(optSurfer.isPresent()){
            return surferMapper.surferToDto(optSurfer.get());
        } else {
            throw new RuntimeException("Failed to find surfer for id " + id );
        }
        //return entityManager.find(Surfer.class, id);
    }

}
