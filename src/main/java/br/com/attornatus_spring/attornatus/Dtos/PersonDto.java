package br.com.attornatus_spring.attornatus.Dtos;

import java.time.LocalDate;

import java.util.List;
import br.com.attornatus_spring.attornatus.Models.Adress;

public class PersonDto {
    private Long id;
    private String name;
    private LocalDate birthday;
    private List<Adress> listOfAdress;     
    
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

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<Adress> getListOfAdress() {
        return listOfAdress;
    }


    public void setListOfAdress(List<Adress> listOfAdress) {
        this.listOfAdress = listOfAdress;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }   

    
    
    
      

}
