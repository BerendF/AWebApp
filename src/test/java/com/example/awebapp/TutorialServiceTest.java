package com.example.awebapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class TutorialServiceTest {
    @Mock
    private TutorialRepository tutorialRepository;
    private TutorialService tutorialService;

    @Mock
    Tutorial tutorial;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tutorialService = new TutorialService(tutorialRepository);
    }

    @Test
    void getTutorialById() {

        tutorialService.getTutorialById(any());

        verify(tutorialRepository).findById(any());
    }

    @Test
    void getAll() {

        tutorialService.getAll();

        verify(tutorialRepository).findAll();
    }

    @Test
    void add() {

        tutorialService.add(tutorial);

        verify(tutorialRepository).save(tutorial);
    }
}