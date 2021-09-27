package com.example.awebapp;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class TutorialControllerTest {

    @Mock
    private TutorialService tutorialService;
    private TutorialController tutController;

    @Mock
    Tutorial tutorial;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        tutController = new TutorialController(tutorialService);
    }

    @Test
    void getAllTutorials(){

        tutController.getAllTutorials();

        verify(tutorialService).getAll();
    }
    @Test
    void addTutorial() {


        tutController.addTutorial(tutorial);

        verify(tutorialService).add(tutorial);
    }
}