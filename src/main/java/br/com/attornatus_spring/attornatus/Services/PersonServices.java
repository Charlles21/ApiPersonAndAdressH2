package br.com.attornatus_spring.attornatus.Services;

import java.util.List;

import br.com.attornatus_spring.attornatus.Dtos.PersonDto;
import br.com.attornatus_spring.attornatus.Models.Person;

public interface PersonServices  {
     List<PersonDto> listAllPerson();
     PersonDto registerAnewPerson(PersonDto person);
}
