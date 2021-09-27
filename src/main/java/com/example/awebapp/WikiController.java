package com.example.awebapp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WikiController {

    private WikiService wikiService;

    public WikiController(WikiService wikiService) {
        this.wikiService = wikiService;
    }


    @GetMapping("/wikis")
    public List<Wiki> getAllWikis() {
        return wikiService.getAll();
    }

    @PostMapping("/wikis")
    public void addWiki(@RequestBody Wiki wiki) {
        wikiService.add(wiki);
    }
}
