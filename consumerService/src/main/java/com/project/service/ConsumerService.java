package com.project.service;


import com.project.dto.PersonDTO;
import com.project.model.Person;
import com.project.repository.PersonRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class ConsumerService {
    @Autowired
    PersonRepository repository;
    @Autowired
    ModelMapper modelMapper;

    private final LocalDate minDate = LocalDate.of(1942, 1, 1);
    private final LocalDate maxDate = LocalDate.of(2004, 1, 1);
    private final double MAX_SUM = 50000000;

    @KafkaListener(topics = "requests", groupId = "requests_groupId")
    public void consume(PersonDTO personDTO) {
        System.out.println("Consuming the message: " + personDTO);
        Person person = modelMapper.map(personDTO, Person.class);
        if ((personDTO.getBirthday().isAfter(minDate) && personDTO.getBirthday().isBefore(maxDate)) && (personDTO.getCreditAmount() < MAX_SUM)) {
            person.setAllowed(true);
        }
        repository.save(person);
    }
}

