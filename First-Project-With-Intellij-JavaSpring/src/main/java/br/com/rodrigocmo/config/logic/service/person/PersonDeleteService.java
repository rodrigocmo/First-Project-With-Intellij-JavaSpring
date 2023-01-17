package br.com.rodrigocmo.config.logic.service.person;

import br.com.rodrigocmo.config.db.Person;
import br.com.rodrigocmo.config.logic.repository.PersonReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class PersonDeleteService {

    private Logger logger = Logger.getLogger(PersonDeleteService.class.getName());

    @Autowired
    PersonReadRepository personRepository;

    public void delete(Long id) {

        logger.info("Deleting one person!");

        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        personRepository.delete(entity);
    }
}