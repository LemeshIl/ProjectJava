package com.project.service;

import com.project.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProducerService {
    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public void produce(PersonDTO personDTO) {
        kafkaTemplate.send("requests", personDTO);
    }
}
