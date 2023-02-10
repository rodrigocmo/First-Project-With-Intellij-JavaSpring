package br.com.rodrigocmo.config.logic.service.person;

import br.com.rodrigocmo.config.db.Person;
import br.com.rodrigocmo.config.db.PersonDTO;
import br.com.rodrigocmo.config.logic.repository.PersonReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonWriteService {

    private Logger logger = Logger.getLogger(PersonWriteService.class.getName());

    @Autowired
    PersonReadRepository personRepository;


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

    public ResponseEntity<List<Person>> createMany(PersonDTO manyPerson){
       return ResponseEntity.ok(personRepository.saveAll(manyPerson.getPersonList()));

    }
}