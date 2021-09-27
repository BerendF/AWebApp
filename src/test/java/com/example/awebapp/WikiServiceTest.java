package com.example.awebapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class WikiServiceTest {
    @Mock
    private WikiRepository wikiRepository;
    private WikiService wikiService;

    @Mock
    Wiki wiki;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        wikiService = new WikiService(wikiRepository);
    }

    @Test
    void getWikiById() {

        wikiService.getWikiById(any());

        verify(wikiRepository).findById(any());
    }

    @Test
    void getAll() {

        wikiService.getAll();

        verify(wikiRepository).findAll();
    }

    @Test
    void add() {

        wikiService.add(wiki);

        verify(wikiRepository).save(wiki);
    }
}