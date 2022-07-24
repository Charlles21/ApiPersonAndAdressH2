package br.com.attornatus_spring.attornatus.Services;

import java.util.List;
import java.util.Optional;

import br.com.attornatus_spring.attornatus.Dtos.PersonDto;
import br.com.attornatus_spring.attornatus.Models.Adress;


public interface PersonServices  {
     List<PersonDto> listAllPerson();
     PersonDto registerAnewPerson(PersonDto person);
     Optional<PersonDto> findPersonById(Long id);
     PersonDto updatePersonById(Long id, PersonDto personDto);
     Optional<PersonDto> registerAnewAdressToPerosnById(Long id, Adress adress);

}
