package br.com.attornatus_spring.attornatus.Dtos;

import java.util.List;
import java.util.stream.Collectors;
import br.com.attornatus_spring.attornatus.Enums.StatusAdress;
import br.com.attornatus_spring.attornatus.Models.Adress;

public class AdressDto {   
    private String street;
    private String CEP;
    private int number;
    private String city;   
    private StatusAdress status_adress;

    public AdressDto(Adress adress){
        this.street = adress.getStreet();
        this.CEP = adress.getCEP();
        this.number = adress.getNumber();
        this.city = adress.getCity();
        this.status_adress = adress.getStatus_adress();
    }
    
    public String getStreet() {
        return street;
    }   
    public String getCEP() {
        return CEP;
    }   
    public int getNumber() {
        return number;
    }    
    public String getCity() {
        return city;
    }    
    public StatusAdress getStatus_adress() {
        return status_adress;
    }

    public static List<AdressDto> changedPersonToDtoPerson(List<Adress> adress){
        return adress.stream().map(AdressDto::new).collect(Collectors.toList());
    } 

}
