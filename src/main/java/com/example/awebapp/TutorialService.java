package com.example.awebapp;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {


    private TutorialRepository tutorialRepository;

    public TutorialService(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    public Optional<Tutorial> getTutorialById(Integer id) {
        return tutorialRepository.findById(id);
    }

    public List<Tutorial> getAll() {
        return (List<Tutorial>) tutorialRepository.findAll();
    }

    public void add(Tutorial tutorial) {
        tutorialRepository.save(tutorial);

    }

}
