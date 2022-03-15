package com.project.controller;


import com.project.dto.PersonDTO;

import com.project.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ProducerController {
    @Autowired
    private ProducerService producerService;

    @PostMapping("/requests")
    public void generate(@RequestBody PersonDTO personDTO) {
        producerService.produce(personDTO);
        System.out.println("Producing the message: " + personDTO);
    }
}
