package br.com.attornatus_spring.attornatus.Services;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<PersonDto> findPersonById(Long id) {
       Optional<Person> person = repositoryPerson.findById(id);   
       
       if(person.isPresent()){
        PersonDto personDto = new ModelMapper().map(person.get(), PersonDto.class);
        return Optional.of(personDto);
       }
              
       return Optional.empty();
    }


    @Override
    public PersonDto updatePersonById(Long id, PersonDto personDto) {
       Optional<Person> person = repositoryPerson.findById(id);
        if(person.isPresent()){
            Person personUpdate = mapper.map(personDto, Person.class);
            personUpdate.setId(id);
            return mapper.map(personUpdate, PersonDto.class);
        }
        
        return null;
    }






    private PersonDto returnExpetedResult(Person personRegister) {
        return mapper.map(personRegister, PersonDto.class);
    }

    private Person modelPersonDtoToPerson(PersonDto person) {
        Person personRegister = mapper.map(person, Person.class);        
        return personRegister;
    }

    
    

   
    
}
