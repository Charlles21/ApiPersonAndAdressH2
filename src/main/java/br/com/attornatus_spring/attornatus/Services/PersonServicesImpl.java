package br.com.attornatus_spring.attornatus.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.com.attornatus_spring.attornatus.Dtos.PersonDto;
import br.com.attornatus_spring.attornatus.Models.Adress;
import br.com.attornatus_spring.attornatus.Models.Person;
import br.com.attornatus_spring.attornatus.Repositorys.AdressRepository;
import br.com.attornatus_spring.attornatus.Repositorys.PersonRepository;
@Service
public class PersonServicesImpl implements PersonServices{

    @Autowired
    private PersonRepository repositoryPerson;
    @Autowired
    private AdressRepository repositoryAdress;

    private ModelMapper mapper = new ModelMapper();
    


    @Override
    public List<PersonDto> listAllPerson() {
        List<Person> person = repositoryPerson.findAll();

        return person.stream().map(p -> mapper.map(p, PersonDto.class)).collect(Collectors.toList());
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
        person.get();
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

   
    public Optional<PersonDto> registerAnewAdressToPerosnById(Long id, Adress adress) {
        Optional<Person> personFinded = repositoryPerson.findById(id);

        if(personFinded.isPresent()){
            List<Adress> adressList = new ArrayList<>();
            personFinded.get();
            PersonDto personDto = new ModelMapper().map(personFinded.get(), PersonDto.class);
            adress.setPerson(personFinded.get());
            repositoryAdress.save(adress);   
            adressList.add(adress);                              
            personDto.setListOfAdress(adressList);
            personDto.setId(id);
            updatePersonById(id, personDto);
            return Optional.of(personDto);

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
