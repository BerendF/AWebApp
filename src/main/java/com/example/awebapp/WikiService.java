package com.example.awebapp;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class WikiService {


    private WikiRepository wikiRepository;

    public WikiService(WikiRepository wikiRepository) {
        this.wikiRepository = wikiRepository;

    }

    public Optional<Wiki> getWikiById(Integer id) {
        return wikiRepository.findById(id);
    }

    public List<Wiki> getAll() {
        return (List<Wiki>) wikiRepository.findAll();
    }

    public void add(Wiki wiki) {
        wikiRepository.save(wiki);

    }

}
