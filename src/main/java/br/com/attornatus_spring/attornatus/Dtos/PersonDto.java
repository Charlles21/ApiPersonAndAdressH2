package br.com.attornatus_spring.attornatus.Dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

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
    
    
    
    public PersonDto(String name, LocalDate birthday, List<Adress> listOfAdress) {
        this.name = name;
        this.birthday = birthday;
        this.listOfAdress = listOfAdress;
    }



    public PersonDto() {
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

    public void setName(String name) {
        this.name = name;
    }


    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }


    public void setListOfAdress(List<Adress> listOfAdress) {
        this.listOfAdress = listOfAdress;
    }


    public static List<PersonDto> changedPersonToDtoPerson(List<Person> person){
        return person.stream().map(PersonDto::new).collect(Collectors.toList());
    }   
    
    
      

}
