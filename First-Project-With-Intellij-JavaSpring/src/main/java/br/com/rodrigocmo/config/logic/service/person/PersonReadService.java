package br.com.rodrigocmo.config.logic.service.person;

import br.com.rodrigocmo.config.controller.PersonController;
import br.com.rodrigocmo.config.db.Person;
import br.com.rodrigocmo.config.logic.repository.PersonReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonReadService {

    private Logger logger = Logger.getLogger(PersonReadService.class.getName());

    @Autowired
    PersonReadRepository personRepository;

    public List<Person> findAll() {

        logger.info("Finding all people!");

        return personRepository.findAll();
    }

    public Person findById(Long id) {

        logger.info("Finding one person!");

        Person before = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        before.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PersonController.class).findById(id)).withSelfRel());
        return before;
    }

    public Person create(Person person) {

        logger.info("Creating one person!");

        return personRepository.save(person);
    }

    public Person update(Person person) {

        logger.info("Updating one person!");

        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(person);
    }

    public void delete(Long id) {

        logger.info("Deleting one person!");

        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        personRepository.delete(entity);
    }
}