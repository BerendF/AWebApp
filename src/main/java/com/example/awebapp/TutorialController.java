package com.example.awebapp;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TutorialController {

    private final TutorialRepository tutorialRepository;

    public TutorialController(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    @GetMapping("/tutorials")
    public List<Tutorial> getAllTutorials() {
        return (List<Tutorial>) tutorialRepository.findAll();
    }

    @PostMapping("/tutorials")
    void addTutorial(@RequestBody Tutorial tutorial) {

        tutorialRepository.save(tutorial);
    }
}
