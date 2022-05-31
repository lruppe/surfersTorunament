package com.example.mySurferApplication.DemoApplication.Mappers;

import com.example.mySurferApplication.DemoApplication.Services.Entities.Contest;
import com.example.mySurferApplication.DemoApplication.Services.Entities.ContestDto;
import com.example.mySurferApplication.DemoApplication.Services.Entities.Surfer;
import com.example.mySurferApplication.DemoApplication.Services.Entities.SurferDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ContestMapper {
    @Mappings({
            @Mapping(target = "maxParticipants", source = "maxNrOfSurfer")
    })
    ContestDto contestToDto(Contest contest);

    @Mappings({
            @Mapping(target = "maxNrOfSurfer", source = "maxParticipants")
    })
    Contest dtoToContest (ContestDto contestDto);

}
