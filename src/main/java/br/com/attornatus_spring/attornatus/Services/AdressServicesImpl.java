package br.com.attornatus_spring.attornatus.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.attornatus_spring.attornatus.Dtos.AdressDto;
import br.com.attornatus_spring.attornatus.Models.Adress;
import br.com.attornatus_spring.attornatus.Repositorys.AdressRepository;

@Service
public class AdressServicesImpl implements AdressServices {

    @Autowired
    private AdressRepository repositoryAdress;


    @Override
    public List<AdressDto> listAllAdress() {      
        return AdressDto.changedPersonToDtoPerson(repositoryAdress.findAll());
    }


    @Override
    public List<AdressDto> listAllPersonAdressById(Long id) {       
        return AdressDto.changedPersonToDtoPerson(repositoryAdress.findAllAdressByPerson_Id(id));
    }
    
}
