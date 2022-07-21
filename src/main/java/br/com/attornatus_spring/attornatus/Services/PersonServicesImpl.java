package br.com.attornatus_spring.attornatus.Services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.com.attornatus_spring.attornatus.Dtos.PersonDto;
import br.com.attornatus_spring.attornatus.Models.Person;
import br.com.attornatus_spring.attornatus.Repositorys.PersonRepository;
@Service
public class PersonServicesImpl implements PersonServices{

    @Autowired
    private PersonRepository repositoryPerson;

    private ModelMapper mapper = new ModelMapper();


    @Override
    public List<PersonDto> listAllPerson() {
        
        return PersonDto.changedPersonToDtoPerson(repositoryPerson.findAll());
    }

    @Override
    public PersonDto registerAnewPerson(PersonDto person) {
      Person personRegister = modelPersonDtoToPerson(person);
      repositoryPerson.save(personRegister);
        return returnExpetedResult(personRegister);
    }

    private PersonDto returnExpetedResult(Person personRegister) {
        return mapper.map(personRegister, PersonDto.class);
    }

    private Person modelPersonDtoToPerson(PersonDto person) {
        Person personRegister = mapper.map(person, Person.class);        
        return personRegister;
    }

   
    
}
