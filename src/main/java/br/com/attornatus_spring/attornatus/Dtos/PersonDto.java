package br.com.attornatus_spring.attornatus.Dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.attornatus_spring.attornatus.Models.Adress;
import br.com.attornatus_spring.attornatus.Models.Person;

public class PersonDto {
    
    private String name;
    private LocalDate birthday; 
    private List<Adress> listOfAdress;

    

    public PersonDto(Person person) {
        this.name = person.getName();
        this.birthday = person.getBirthday();
        this.listOfAdress = person.getListOfAdress();

    }
    
    public String getName() {
        return name;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public List<Adress> getListOfAdress() {
        return listOfAdress;
    }

    public static List<PersonDto> changedPersonToDtoPerson(List<Person> person){
        return person.stream().map(PersonDto::new).collect(Collectors.toList());
    }


}
