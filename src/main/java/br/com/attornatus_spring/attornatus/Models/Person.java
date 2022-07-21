package br.com.attornatus_spring.attornatus.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate birthday;
    @ManyToMany(mappedBy = "")
    private List<Adress> listOfAdress = new ArrayList<>();

  

    public Person(Long id, String name, LocalDate birthday, List<Adress> listOfAdress) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.listOfAdress = listOfAdress;
    }

    
    public Person() {
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getBirthday() {
        return birthday;
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
