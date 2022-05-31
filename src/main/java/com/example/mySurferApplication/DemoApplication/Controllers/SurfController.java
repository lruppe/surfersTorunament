package com.example.mySurferApplication.DemoApplication.Controllers;

import com.example.mySurferApplication.DemoApplication.Services.Entities.Contest;
import com.example.mySurferApplication.DemoApplication.Services.ContestService;
import com.example.mySurferApplication.DemoApplication.Services.Entities.Surfer;
import com.example.mySurferApplication.DemoApplication.Services.Entities.SurferDto;
import com.example.mySurferApplication.DemoApplication.Services.SurferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/*
 curl -XPOST "localhost:8080/surfer" -H "Content-Type: application/json" -d "{\"name\" : \"leon\", \"country\" : \"swiss\"}"
 curl -XPOST "localhost:8080/surfer" -H "Content-Type: application/json" -d "{\"name\" : \"michele\", \"country\" : \"italian\"}"
 curl -XPOST "localhost:8080/contest?place=lucerne&nrOfSurfer=5"
 curl -XPOST "localhost:8080/1/3/register"
 curl -XGET "localhost:8080/3/contest"
 curl -XGET "localhost:8080/1/surfer"
*/


@RestController
public class SurfController {

    @Autowired
    private ContestService contestService;

    @Autowired
    private SurferService surferService;
//
//    public SurfController (ContestService contestService) {
//        this.contestService = contestService;
//    }

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

    @PostMapping(value = "/{surferId}/{contestId}/register")
    public Contest registerSurfer(@PathVariable(value = "surferId") Long surferId, @PathVariable(value = "contestId") Long contestId) {
        return contestService.registerSurferAtContest(surferId, contestId);
    }



}
