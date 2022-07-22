package br.com.attornatus_spring.attornatus.Models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.attornatus_spring.attornatus.Enums.StatusAdress;

@Entity
@Table(name = "adress")
public class Adress {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String CEP;
    private int number;
    private String city;
    @Enumerated(EnumType.STRING)
    private StatusAdress status_adress;
    @JoinColumn(name = "person_id")
    @ManyToOne
    private Person person;

    public String getStreet() {
        return street;
    }
    public void setPatio(String street) {
        this.street = street;
    }
    public String getCEP() {
        return CEP;
    }
    public void setCEP(String cEP) {
        CEP = cEP;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public StatusAdress getStatus_adress() {
        return status_adress;
    }
    public void setStatus_adress(StatusAdress status_adress) {
        this.status_adress = status_adress;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    
}
