package com.example.awebapp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TutorialController {

    private TutorialService tutorialService;

    public TutorialController(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @GetMapping("/tutorials")
    public List<Tutorial> getAllTutorials() {
        return tutorialService.getAll();
    }

    @PostMapping("/tutorials")
    public void addTutorial(@RequestBody Tutorial tutorial) {

        tutorialService.add(tutorial);
    }
}
