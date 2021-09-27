package com.example.awebapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiRepository extends CrudRepository<Wiki, Integer> {
}
