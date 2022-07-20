package br.com.attornatus_spring.attornatus.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.attornatus_spring.attornatus.Dtos.PersonDto;
import br.com.attornatus_spring.attornatus.Repositorys.PersonRepository;
@Service
public class PersonServicesImpl implements PersonServices{

    @Autowired
    PersonRepository repositoryPerson;

    @Override
    public List<PersonDto> listAllPerson() {
        
        return PersonDto.changedPersonToDtoPerson(repositoryPerson.findAll());
    }
    
}
