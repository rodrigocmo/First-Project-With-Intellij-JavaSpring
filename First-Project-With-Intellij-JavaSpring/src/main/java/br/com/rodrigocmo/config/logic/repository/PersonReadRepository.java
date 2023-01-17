package br.com.rodrigocmo.config.logic.repository;

import br.com.rodrigocmo.config.db.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonReadRepository extends JpaRepository<Person, Long>, PersonReadRepositoryCustom {
}
