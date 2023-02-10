package br.com.rodrigocmo.config.controller;

import br.com.rodrigocmo.config.db.Person;
import br.com.rodrigocmo.config.db.PersonDTO;
import br.com.rodrigocmo.config.logic.service.person.PersonReadService;
import br.com.rodrigocmo.config.logic.service.person.PersonWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/person")

public class PersonController {

    @Autowired
    PersonReadService personReadService;

    @Autowired
    PersonWriteService personWriteService;

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id){
        return new ResponseEntity<>(personReadService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll(){
        return new ResponseEntity<>(personReadService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        return personWriteService.create(person);
    }

    @PostMapping(path = "/manyperson")
    public ResponseEntity<List<Person>> createMany(@RequestBody PersonDTO personList){
        return personWriteService.createMany(personList);
    }


}
