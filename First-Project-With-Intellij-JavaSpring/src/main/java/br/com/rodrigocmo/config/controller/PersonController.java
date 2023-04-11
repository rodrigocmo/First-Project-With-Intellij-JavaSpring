package br.com.rodrigocmo.config.controller;

import br.com.rodrigocmo.config.db.Person;
import br.com.rodrigocmo.config.logic.service.person.PersonReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/person")

public class PersonController {

    @Autowired
    PersonReadService personReadService;


    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id){
        return new ResponseEntity<>(personReadService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        return personReadService.create(person);
    }

    @GetMapping
    public ResponseEntity<Page<Person>> findAll(@RequestParam (value = "page" , defaultValue = "0") Integer page,
    @RequestParam (value = "limit" , defaultValue = "12") Integer limit){
        Pageable pageable = PageRequest.of(page,limit);

        return new ResponseEntity<>(personReadService.findAll(pageable), HttpStatus.OK);
    }

}
