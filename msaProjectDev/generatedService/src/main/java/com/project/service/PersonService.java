package com.project.service;

import com.project.exception.PersonNotFoundException;
import com.project.model.Person;
import com.project.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person getOne(UUID id) {
        return repository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }
}