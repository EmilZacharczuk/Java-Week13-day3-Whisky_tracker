package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;



    @GetMapping(value = "/year/{year}")
    public List<Whisky> foundWhiskyByYear(@PathVariable int year) {
        return whiskyRepository.findWhiskyByYear(year);
    }

    @GetMapping(value = "/{name}/{age}")
    public List<Whisky> foundWhiskyByAgeInParticularDistillery(@PathVariable String name, int age) {
        return whiskyRepository.findWhiskyInSpecificDistilleryByYear(name,age);
    }
}
