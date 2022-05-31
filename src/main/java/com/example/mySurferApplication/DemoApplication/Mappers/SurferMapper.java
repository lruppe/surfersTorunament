package com.example.mySurferApplication.DemoApplication.Mappers;

import com.example.mySurferApplication.DemoApplication.Services.Entities.Surfer;
import com.example.mySurferApplication.DemoApplication.Services.Entities.SurferDto;
import org.mapstruct.Mapper;

@Mapper
public interface SurferMapper {
    SurferDto surferToDto(Surfer surfer);
    Surfer dtoToSurfer (SurferDto surferDto);

}
