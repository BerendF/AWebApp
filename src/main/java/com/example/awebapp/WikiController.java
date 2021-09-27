package com.example.awebapp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WikiController {

    private final WikiRepository wikiRepository;

    public WikiController(WikiRepository wikiRepository) {
        this.wikiRepository = wikiRepository;
    }


    @GetMapping("/wikis")
    public List<Wiki> getAllTutorials() {
        return (List<Wiki>) wikiRepository.findAll();
    }

    @PostMapping("/wikis")
    void addTutorial(@RequestBody Wiki wiki) {
        wikiRepository.save(wiki);
    }
}
