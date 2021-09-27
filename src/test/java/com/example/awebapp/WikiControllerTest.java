package com.example.awebapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class WikiControllerTest {

    @Mock
    private WikiService wikiService;
    private WikiController wikiController;

    @Mock
    Wiki wiki;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        wikiController = new WikiController(wikiService);
    }

    @Test
    void getAllTutorials() {

        wikiController.getAllWikis();

        verify(wikiService).getAll();
    }

    @Test
    void addTutorial() {

        wikiController.addWiki(wiki);

        verify(wikiService).add(wiki);
    }
}