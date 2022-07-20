package br.com.attornatus_spring.attornatus.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attornatus_spring.attornatus.Models.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
