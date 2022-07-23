package br.com.attornatus_spring.attornatus.Services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.attornatus_spring.attornatus.Dtos.AdressDto;
import br.com.attornatus_spring.attornatus.Dtos.PersonDto;
import br.com.attornatus_spring.attornatus.Models.Adress;
import br.com.attornatus_spring.attornatus.Models.Person;
import br.com.attornatus_spring.attornatus.Repositorys.AdressRepository;

@Service
public class AdressServicesImpl implements AdressServices {

    @Autowired
    private AdressRepository repositoryAdress;
    @Autowired
    private PersonServicesImpl servicesPersonImpl; 

    ModelMapper mapper = new ModelMapper();

    @Override
    public List<AdressDto> listAllAdress() {      
        return AdressDto.changedPersonToDtoPerson(repositoryAdress.findAll());
    }


    @Override
    public List<AdressDto> listAllPersonAdressById(Long id) {       
        return AdressDto.changedPersonToDtoPerson(repositoryAdress.findAllAdressByPerson_Id(id));
    }


    @Override
    public AdressDto registerAnewAdressForPerson(Long id, AdressDto adress) {
        Adress adressRegister = mapper.map(adress, Adress.class);
        Person person = new ModelMapper().map(servicesPersonImpl.findPersonById(id).get(), Person.class);      
        //adressRegister.setPerson(person);
        repositoryAdress.save(adressRegister);          
        return mapper.map(adressRegister, AdressDto.class);
    }
    
}
