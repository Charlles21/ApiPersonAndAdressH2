package br.com.attornatus_spring.attornatus.Dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.attornatus_spring.attornatus.Models.Person;

public class PersonDto {
    
    private String name;
    private LocalDate birthday; 
 
  

    public PersonDto(Person person) {
        this.name = person.getName();
        this.birthday = person.getBirthday();        
    }
    
    public PersonDto(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;       
    }

    public PersonDto() {
    }

    public String getName() {
        return name;
    }
    public LocalDate getBirthday() {
        return birthday;
    }  

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public static List<PersonDto> changedPersonToDtoPerson(List<Person> person){
        return person.stream().map(PersonDto::new).collect(Collectors.toList());
    }   
    
    
      

}
