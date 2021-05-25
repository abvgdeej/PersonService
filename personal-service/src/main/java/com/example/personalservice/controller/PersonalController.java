package com.example.personalservice.controller;

import com.example.personalservice.client.NumberGeneratorClient;
import com.example.personalservice.persist.PersonEntity;
import com.example.personalservice.persist.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@RestController("/personal")
public class PersonalController {
    private final NumberGeneratorClient client;
    private final PersonRepository repository;

    public PersonalController(NumberGeneratorClient client, PersonRepository repository) {
        this.client = client;
        this.repository = repository;
    }

    @GetMapping("/")
    public ResponseEntity<Response> getPersons() {
        List<PersonEntity> list = repository.findAll();
        log.info("There are {} persons in the list", list.size());
        return new ResponseEntity<>(new Response(list), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<PersonEntity> createPerson(@NotNull Request request) {
        Long personalNumber = client.getNumber().getBody();
        if (personalNumber == null) {
            log.error("Generated number is null");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        PersonEntity entity = new PersonEntity(personalNumber, request.getName(), request.getSurname(), request.getDepartment());
        repository.save(entity);
        log.info("Saved person {}", entity);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
}
