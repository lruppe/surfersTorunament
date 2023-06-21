package com.example.mySurferApplication.DemoApplication.Controllers;

import com.example.mySurferApplication.DemoApplication.Services.Entities.Contest;
import com.example.mySurferApplication.DemoApplication.Services.ContestService;
import com.example.mySurferApplication.DemoApplication.Services.Entities.Surfer;
import com.example.mySurferApplication.DemoApplication.Services.Entities.SurferDto;
import com.example.mySurferApplication.DemoApplication.Services.SurferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SurfController {

    @Autowired
    private ContestService contestService;

    @Autowired
    private SurferService surferService;

    @PostMapping (value="/contest")
    public Contest createContest(@RequestParam("place") String place, @RequestParam("nrOfSurfer") Integer nrOfSurfer) {
        return contestService.createContest(place, nrOfSurfer);
    }

    @GetMapping (value = "/{id}/contest")
    public Contest getActiveContest(@PathVariable(value="id") Long id){
        return contestService.getContest(id);
    }

    @PostMapping(value = "/surfer")
    public SurferDto createSurfer (@RequestBody SurferDto surferDto){
        return surferService.createSurfer(surferDto);
    }

    @GetMapping(value = "/{id}/surfer")
    public SurferDto getSurfers(@PathVariable(value="id") Long id){
        return surferService.getSurfers(id);
    }
    @GetMapping(value = "/maleSurfers")
    public List<SurferDto> getMaleSurfers(){
        return surferService.getMaleSurfers();
    }

    //just for testing
    @GetMapping(value = "/maleSurfersSql")
    public List<SurferDto> getMaleSurfersSql(){ return surferService.getMaleSurfersWithSQL();}

    @PostMapping(value = "/{surferId}/{contestId}/register")
    public Contest registerSurfer(@PathVariable(value = "surferId") Long surferId, @PathVariable(value = "contestId") Long contestId) {
        return contestService.registerSurferAtContest(surferId, contestId);
    }



}
